package com.salesforce.marketingcloud.messages.iam;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.salesforce.marketingcloud.R;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.io.encoding.Base64;
import o.ArtificialStackFrames;
import o.onNavigationEvent;
import okio.Utf8;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes3.dex */
public class IamFullscreenActivity extends f {
    protected View g;
    private k h;
    private InAppMessage i;
    private static final byte[] $$l = {96, -63, 33, 4};
    private static final int $$o = 207;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$m = {6, 70, -89, 92, -1, 0, Ascii.SI, 3, -1, -58, -2, 62, 8, 9, -12, Ascii.DLE, -1, -10, Ascii.SO, -59, 76, -1, -66, 39, Ascii.SYN, -1, Ascii.SO, -18, 17, 0, -12, Ascii.US, -9, Ascii.VT, -3, Ascii.DC2, -77, 54, Ascii.RS, -6, Ascii.SO, -12, Ascii.DLE, -27, Ascii.DLE, Ascii.NAK, -5, 3, SignedBytes.MAX_POWER_OF_TWO, Ascii.SI, 1, -60, 60, Ascii.VT, 3, -5, 8, -4, -52, 54, Ascii.DLE, -7, 17, 0, -3, -2, -51, 66, -9, Ascii.SYN, -12, Ascii.DLE, -6, -5, Ascii.SO, -59, 56, Ascii.SI, 0, 6, 6, -65, 74, 2, -8, 6, 0, Ascii.SO, -8, -1, 17, -66, Ascii.EM, 56, -8, -10, Ascii.SI, -1, -3, -29, 47, 0, 6, 6, -75, 3, 36, 54, -1, -12, Ascii.DLE, -1, -10, Ascii.SO, -22, 41, -8, 9, -9, 0, Ascii.DC2, -8, -3, -20, Ascii.CAN, Ascii.SI, -8, 5, 0, -46};
    private static final int $$n = 212;
    private static final byte[] $$d = {Base64.padSymbol, 55, -5, -17, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR};
    private static final int $$e = 74;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int setDefaultImpl = -260894002;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[InAppMessage.Type.values().length];
            b = iArr;
            try {
                iArr[InAppMessage.Type.full.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[InAppMessage.Type.fullImageFill.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[InAppMessage.LayoutOrder.values().length];
            a = iArr2;
            try {
                iArr2[InAppMessage.LayoutOrder.ImageTitleBody.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[InAppMessage.LayoutOrder.TitleImageBody.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0028
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$r(int r6, byte r7, byte r8) {
        /*
            int r7 = r7 * 4
            int r7 = r7 + 4
            byte[] r0 = com.salesforce.marketingcloud.messages.iam.IamFullscreenActivity.$$l
            int r6 = r6 * 3
            int r1 = 1 - r6
            int r8 = r8 * 2
            int r8 = r8 + 114
            byte[] r1 = new byte[r1]
            r2 = 0
            int r6 = 0 - r6
            if (r0 != 0) goto L19
            r4 = r6
            r8 = r7
            r3 = r2
            goto L2f
        L19:
            r3 = r2
        L1a:
            r5 = r8
            r8 = r7
            r7 = r5
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L28:
            r4 = r0[r8]
            int r3 = r3 + 1
            r5 = r8
            r8 = r7
            r7 = r5
        L2f:
            int r7 = r7 + 1
            int r4 = -r4
            int r8 = r8 + r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.iam.IamFullscreenActivity.$$r(int, byte, byte):java.lang.String");
    }

    private int a(InAppMessage inAppMessage) {
        int i = R.layout.mcsdk_iam_full_inset_itb;
        int i2 = a.b[inAppMessage.type().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return i;
            }
            return (inAppMessage.media() == null || inAppMessage.media().size() != InAppMessage.Media.ImageSize.e2e) ? R.layout.mcsdk_iam_fif_inset_itb : R.layout.mcsdk_iam_fif_e2e_itb;
        }
        int i3 = a.a[inAppMessage.layoutOrder().ordinal()];
        if (i3 == 1) {
            return (inAppMessage.media() == null || inAppMessage.media().size() != InAppMessage.Media.ImageSize.e2e) ? R.layout.mcsdk_iam_full_inset_itb : R.layout.mcsdk_iam_full_e2e_itb;
        }
        if (i3 != 2) {
            return i;
        }
        return (inAppMessage.media() == null || inAppMessage.media().size() != InAppMessage.Media.ImageSize.e2e) ? R.layout.mcsdk_iam_full_inset_tib : R.layout.mcsdk_iam_full_e2e_tib;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void m(byte r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 + 1
            int r9 = r9 + 36
            int r8 = 48 - r8
            byte[] r0 = com.salesforce.marketingcloud.messages.iam.IamFullscreenActivity.$$m
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L11
            r3 = r7
            r9 = r8
            r5 = r2
            goto L29
        L11:
            r3 = r2
        L12:
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            int r8 = r8 + 1
            if (r5 != r7) goto L23
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L23:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r6
        L29:
            int r3 = r3 + r8
            int r8 = r3 + (-3)
            r3 = r5
            r6 = r9
            r9 = r8
            r8 = r6
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.iam.IamFullscreenActivity.m(byte, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002a  */
    /* JADX WARN: Code duplicated, block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002a
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void n(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.salesforce.marketingcloud.messages.iam.IamFullscreenActivity.$$d
            int r7 = r7 * 3
            int r7 = r7 + 9
            int r8 = r8 + 4
            int r6 = r6 * 28
            int r6 = r6 + 84
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L15
            r4 = r7
            r6 = r8
            r3 = r2
            goto L2c
        L15:
            r3 = r2
            r5 = r8
            r8 = r6
            r6 = r5
        L19:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r6 = r6 + 1
            int r3 = r3 + 1
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r4 = r0[r6]
        L2c:
            int r8 = r8 + r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.iam.IamFullscreenActivity.n(byte, int, int, java.lang.Object[]):void");
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f
    public /* bridge */ /* synthetic */ void b(InAppMessage.Button button) {
        super.b(button);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, android.app.Activity
    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, android.view.View.OnClickListener
    public /* bridge */ /* synthetic */ void onClick(View view) {
        super.onClick(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        k kVar;
        super.onConfigurationChanged(configuration);
        InAppMessage inAppMessage = this.i;
        if (inAppMessage == null || inAppMessage.type() != InAppMessage.Type.fullImageFill || configuration.orientation != 2 || (kVar = this.h) == null) {
            return;
        }
        kVar.a(j.a(kVar.k(), this.h.j()));
        finish();
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (isFinishing()) {
            return;
        }
        this.g = findViewById(android.R.id.content);
        k kVarC = c();
        this.h = kVarC;
        InAppMessage inAppMessageL = kVarC.l();
        this.i = inAppMessageL;
        setContentView(a(inAppMessageL));
        new e(this, this.h.s()).a(this.g, this.h);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        View view = this.g;
        if (view != null) {
            ViewCompat.setOnApplyWindowInsetsListener(view, null);
        }
        super.onDestroy();
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, com.salesforce.marketingcloud.messages.iam.SwipeDismissConstraintLayout.SwipeDismissListener
    public /* bridge */ /* synthetic */ void onDismissed() {
        super.onDismissed();
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, com.salesforce.marketingcloud.messages.iam.SwipeDismissConstraintLayout.SwipeDismissListener
    public /* bridge */ /* synthetic */ void onSwipeStarted() {
        super.onSwipeStarted();
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, com.salesforce.marketingcloud.messages.iam.SwipeDismissConstraintLayout.SwipeDismissListener
    public /* bridge */ /* synthetic */ void onViewSettled() {
        super.onViewSettled();
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() throws Throwable {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 117;
        artificialFrame = i2 % 128;
        if (i2 % 2 == 0) {
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(AndroidCharacter.getMirror('0') - 18, (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 49993), (ViewConfiguration.getLongPressTimeout() >> 16) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
            }
            Object obj = ((Field) objAccessartificialFrame).get(null);
            try {
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579113874);
                if (objAccessartificialFrame2 == null) {
                    int i3 = 30 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    char deadChar = (char) (49993 - KeyEvent.getDeadChar(0, 0));
                    int doubleTapTimeout = 74 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    byte[] bArr = $$m;
                    byte b = bArr[5];
                    Object[] objArr = new Object[1];
                    m(b, (byte) (b | 45), bArr[11], objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i3, deadChar, doubleTapTimeout, -1048962150, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj, null);
                super.onResume();
                int i4 = 50 / 0;
                return;
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
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(30 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (49994 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), Color.green(0) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj2 = ((Field) objAccessartificialFrame3).get(null);
        try {
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579113874);
            if (objAccessartificialFrame4 == null) {
                int iBlue = 30 - Color.blue(0);
                char doubleTapTimeout2 = (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 49993);
                int scrollBarFadeDuration = 74 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                byte[] bArr2 = $$m;
                byte b2 = bArr2[5];
                Object[] objArr2 = new Object[1];
                m(b2, (byte) (b2 | 45), bArr2[11], objArr2);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iBlue, doubleTapTimeout2, scrollBarFadeDuration, -1048962150, false, (String) objArr2[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame4).invoke(obj2, null);
            super.onResume();
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 101;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        Object obj = null;
        try {
            if (i2 % 2 != 0) {
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Drawable.resolveOpacity(0, 0) + 30, (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 49993), 74 - TextUtils.getOffsetAfter("", 0), -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
                }
                Object obj2 = ((Field) objAccessartificialFrame).get(null);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579114835);
                if (objAccessartificialFrame2 == null) {
                    int iMyTid = 30 - (Process.myTid() >> 22);
                    char pressedStateDuration = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 49993);
                    int iMyPid = 74 - (Process.myPid() >> 22);
                    byte b = $$m[5];
                    byte b2 = (byte) (b | 45);
                    Object[] objArr = new Object[1];
                    m(b, b2, (byte) (b2 | Ascii.DC2), objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMyTid, pressedStateDuration, iMyPid, -1048959141, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj2, null);
                super.onPause();
                obj.hashCode();
                throw null;
            }
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(949068051);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(30 - (Process.myPid() >> 22), (char) (49993 - (Process.myTid() >> 22)), (-16777142) - Color.rgb(0, 0, 0), -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
            }
            Object obj3 = ((Field) objAccessartificialFrame3).get(null);
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579114835);
            if (objAccessartificialFrame4 == null) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0) + 30;
                char cCombineMeasuredStates = (char) (49993 - View.combineMeasuredStates(0, 0));
                int iAxisFromString = MotionEvent.axisFromString("") + 75;
                byte b3 = $$m[5];
                byte b4 = (byte) (b3 | 45);
                Object[] objArr2 = new Object[1];
                m(b3, b4, (byte) (b4 | Ascii.DC2), objArr2);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, cCombineMeasuredStates, iAxisFromString, -1048959141, false, (String) objArr2[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame4).invoke(obj3, null);
            super.onPause();
            int i3 = getARTIFICIAL_FRAME_PACKAGE_NAME + 41;
            artificialFrame = i3 % 128;
            if (i3 % 2 == 0) {
                throw null;
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x016a  */
    /* JADX WARN: Code duplicated, block: B:33:0x016b  */
    private static void o(char[] cArr, int i, int i2, int i3, boolean z, Object[] objArr) throws Throwable {
        long j;
        Throwable cause;
        int i4 = 2 % 2;
        onNavigationEvent onnavigationevent = new onNavigationEvent();
        char[] cArr2 = new char[i];
        onnavigationevent.d = 0;
        while (true) {
            j = 0;
            if (onnavigationevent.d >= i) {
                break;
            }
            int i5 = $10 + 31;
            $11 = i5 % 128;
            int i6 = i5 % 2;
            onnavigationevent.c = cArr[onnavigationevent.d];
            cArr2[onnavigationevent.d] = (char) (i3 + onnavigationevent.c);
            int i7 = onnavigationevent.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr2[i7]), Integer.valueOf(setDefaultImpl)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(22 - ExpandableListView.getPackedPositionGroup(0L), (char) ExpandableListView.getPackedPositionGroup(0L), 1775 - (ViewConfiguration.getLongPressTimeout() >> 16), -2069783171, false, $$r(b, b2, b2), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr2[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onnavigationevent, onnavigationevent};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation('U' - AndroidCharacter.getMirror('0'), (char) (Color.blue(0) + 56277), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1259, 711931141, false, $$r(b3, b4, (byte) (b4 + 1)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
            } catch (Throwable th) {
                cause = th.getCause();
                if (cause != null) {
                    throw th;
                }
                throw cause;
            }
            cause = th.getCause();
            if (cause != null) {
                throw th;
            }
            throw cause;
        }
        if (i2 > 0) {
            onnavigationevent.b = i2;
            char[] cArr3 = new char[i];
            System.arraycopy(cArr2, 0, cArr3, 0, i);
            System.arraycopy(cArr3, 0, cArr2, i - onnavigationevent.b, onnavigationevent.b);
            System.arraycopy(cArr3, onnavigationevent.b, cArr2, 0, i - onnavigationevent.b);
            int i8 = $11 + 39;
            $10 = i8 % 128;
            int i9 = i8 % 2;
        }
        if (z) {
            char[] cArr4 = new char[i];
            onnavigationevent.d = 0;
            while (onnavigationevent.d < i) {
                cArr4[onnavigationevent.d] = cArr2[(i - onnavigationevent.d) - 1];
                Object[] objArr4 = {onnavigationevent, onnavigationevent};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(37 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (56278 - (ViewConfiguration.getGlobalActionKeyTimeout() > j ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == j ? 0 : -1))), (ViewConfiguration.getFadingEdgeLength() >> 16) + 1259, 711931141, false, $$r(b5, b6, (byte) (b6 + 1)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                j = 0;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0207  */
    /* JADX WARN: Code duplicated, block: B:16:0x0309 A[Catch: all -> 0x0ca7, TryCatch #0 {all -> 0x0ca7, blocks: (B:51:0x093a, B:53:0x095a, B:54:0x09a5, B:14:0x02f5, B:16:0x0309, B:17:0x0336), top: B:91:0x02f5 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x034c  */
    /* JADX WARN: Code duplicated, block: B:25:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:50:0x0891  */
    /* JADX WARN: Code duplicated, block: B:53:0x095a A[Catch: all -> 0x0ca7, TryCatch #0 {all -> 0x0ca7, blocks: (B:51:0x093a, B:53:0x095a, B:54:0x09a5, B:14:0x02f5, B:16:0x0309, B:17:0x0336), top: B:91:0x02f5 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x09b7  */
    /* JADX WARN: Code duplicated, block: B:62:0x0ae3  */
    @Override // com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
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
            int minimumFlingVelocity = 26 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
            char cResolveSizeAndState = (char) View.resolveSizeAndState(0, 0, 0);
            int bitsPerPixel = 1040 - ImageFormat.getBitsPerPixel(0);
            byte[] bArr = $$d;
            byte b = bArr[21];
            Object[] objArr2 = new Object[1];
            n(b, (byte) (b - 1), bArr[5], objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, cResolveSizeAndState, bitsPerPixel, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 4611686018427387878L;
            Object[] objArr3 = new Object[1];
            o(new char[]{11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f', 0, '\b', 65534}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 27, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length(), 157 - TextUtils.indexOf((CharSequence) "", '0', 0), false, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            o(new char[]{5, 65530, '\t', '\f', 65534, 65533, 65515, 65534, 65530, 5, CharUtils.CR, 2, 6, 65534, 65534}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 6, 14 - TextUtils.indexOf("", ""), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 127, false, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 95;
                artificialFrame = i2 % 128;
                int i3 = i2 % 2;
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int iLastIndexOf = 25 - TextUtils.lastIndexOf("", '0', 0);
                    char absoluteGravity = (char) Gravity.getAbsoluteGravity(0, 0);
                    int i4 = 1041 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    byte[] bArr2 = $$d;
                    byte b2 = bArr2[21];
                    Object[] objArr5 = new Object[1];
                    n(b2, (byte) (b2 - 1), (byte) (-bArr2[11]), objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, absoluteGravity, i4, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i5 = ((int[]) objArr6[3])[0];
                int i6 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int i7 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigationHidden;
                int i8 = 882496286 + ((~(i7 | 259639109)) * JfifUtil.MARKER_SOI);
                int i9 = ~i7;
                int i10 = ((i8 + ((268158791 | i9) * (-216))) + (((~(i9 | 259639109)) | (-181535303)) * JfifUtil.MARKER_SOI)) - 1710236007;
                int i11 = (i10 << 13) ^ i10;
                int i12 = i11 ^ (i11 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i12 ^ (i12 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                o(new char[]{23, 17, 18, 3, 11, '\b', 65535, 20, 65535, 65484, '\n', 65535, '\f', 5, 65484, 65521}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1, KeyEvent.getDeadChar(0, 0) + 157, false, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                o(new char[]{65534, 65535, 3, 65534, 65535, '\b', 14, 3, 14, 19, 65506, 65531, CharUtils.CR, 2, 65501, '\t'}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 21, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 1, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 124, false, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {2004197692};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - TextUtils.getOffsetAfter("", 0), (char) (ExpandableListView.getPackedPositionType(0L) + 22251), 1033 - (ViewConfiguration.getEdgeSlop() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = com.facebook.core.R.string.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), -1710236007, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int iIndexOf = TextUtils.indexOf("", "", 0, 0) + 26;
                        char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1);
                        int i13 = 1042 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                        byte[] bArr3 = $$d;
                        byte b3 = bArr3[21];
                        Object[] objArr10 = new Object[1];
                        n(b3, (byte) (b3 - 1), (byte) (-bArr3[11]), objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf, cLastIndexOf, i13, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        o(new char[]{11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f', 0, '\b', 65534}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) - 93, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 17, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 154, false, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        o(new char[]{5, 65530, '\t', '\f', 65534, 65533, 65515, 65534, 65530, 5, CharUtils.CR, 2, 6, 65534, 65534}, 14 - ExpandableListView.getPackedPositionChild(0L), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 7, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 127, false, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int iIndexOf2 = 26 - TextUtils.indexOf("", "", 0, 0);
                            char c = (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                            int minimumFlingVelocity2 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 1041;
                            byte[] bArr4 = $$d;
                            byte b4 = bArr4[21];
                            Object[] objArr13 = new Object[1];
                            n(b4, (byte) (b4 - 1), bArr4[5], objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf2, c, minimumFlingVelocity2, 2061780482, false, (String) objArr13[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                        int i14 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
                        artificialFrame = i14 % 128;
                        int i15 = i14 % 2;
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
            o(new char[]{23, 17, 18, 3, 11, '\b', 65535, 20, 65535, 65484, '\n', 65535, '\f', 5, 65484, 65521}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1, KeyEvent.getDeadChar(0, 0) + 157, false, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            o(new char[]{65534, 65535, 3, 65534, 65535, '\b', 14, 3, 14, 19, 65506, 65531, CharUtils.CR, 2, 65501, '\t'}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 21, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 1, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 124, false, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {2004197692};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - TextUtils.getOffsetAfter("", 0), (char) (ExpandableListView.getPackedPositionType(0L) + 22251), 1033 - (ViewConfiguration.getEdgeSlop() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = com.facebook.core.R.string.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), -1710236007, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int iIndexOf3 = TextUtils.indexOf("", "", 0, 0) + 26;
                char cLastIndexOf2 = (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1);
                int i16 = 1042 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                byte[] bArr5 = $$d;
                byte b5 = bArr5[21];
                Object[] objArr17 = new Object[1];
                n(b5, (byte) (b5 - 1), (byte) (-bArr5[11]), objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf3, cLastIndexOf2, i16, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            o(new char[]{11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f', 0, '\b', 65534}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) - 93, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 17, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 154, false, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            o(new char[]{5, 65530, '\t', '\f', 65534, 65533, 65515, 65534, 65530, 5, CharUtils.CR, 2, 6, 65534, 65534}, 14 - ExpandableListView.getPackedPositionChild(0L), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 7, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 127, false, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int iIndexOf4 = 26 - TextUtils.indexOf("", "", 0, 0);
                char c2 = (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                int minimumFlingVelocity3 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 1041;
                byte[] bArr6 = $$d;
                byte b6 = bArr6[21];
                Object[] objArr110 = new Object[1];
                n(b6, (byte) (b6 - 1), bArr6[5], objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf4, c2, minimumFlingVelocity3, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
            int i17 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
            artificialFrame = i17 % 128;
            int i18 = i17 % 2;
        }
        int i19 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i20 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i20 == i19) {
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i21 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i22 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i23 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 1078149808;
            int i24 = ~length;
            int i25 = i21 + (-657362930) + (((~(length | (-50282179))) | (~((-83886338) | i24)) | 5782530) * (-68)) + ((~((-44499649) | i24)) * (-68)) + (((~(50282178 | i24)) | (-128385986)) * 68);
            int i26 = (i25 << 13) ^ i25;
            int i27 = i26 ^ (i26 >>> 17);
            ((int[]) objArr20[1])[0] = i27 ^ (i27 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                int i28 = artificialFrame + 95;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i28 % 128;
                int i29 = i28 % 2;
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf(((long) (i19 ^ i20)) ^ (((long) 1182411576) << 32)), Long.valueOf(1182411578)};
                byte b7 = (byte) 43;
                byte[] bArr7 = $$m;
                Object[] objArr22 = new Object[1];
                m(b7, (byte) (b7 + 2), (byte) (-bArr7[104]), objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b8 = bArr7[83];
                Object[] objArr23 = new Object[1];
                m(b8, b8, bArr7[5], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i30 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i31 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i32 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int i33 = ~System.identityHashCode(this);
                int i34 = i30 + 939692446 + (((~(i33 | 398875171)) | 1606916) * (-160)) + (((~(i33 | 320771364)) | 398875171) * SyslogConstants.LOG_LOCAL4);
                int i35 = (i34 << 13) ^ i34;
                int i36 = i35 ^ (i35 >>> 17);
                ((int[]) objArr24[1])[0] = i36 ^ (i36 << 5);
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
            int deadChar = KeyEvent.getDeadChar(0, 0) + 25;
            char c3 = (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 30068);
            int threadPriority = 816 - ((Process.getThreadPriority(0) + 20) >> 6);
            byte[] bArr8 = $$d;
            byte b9 = bArr8[21];
            Object[] objArr25 = new Object[1];
            n(b9, (byte) (b9 - 1), bArr8[5], objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(deadChar, c3, threadPriority, 721586079, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 2047;
            Object[] objArr26 = new Object[1];
            o(new char[]{11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f', 0, '\b', 65534}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 28, (Process.myPid() >> 22) + 158, false, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            o(new char[]{5, 65530, '\t', '\f', 65534, 65533, 65515, 65534, 65530, 5, CharUtils.CR, 2, 6, 65534, 65534}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(0) - 95, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 7, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) + 47, false, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i37 = getARTIFICIAL_FRAME_PACKAGE_NAME + 93;
                artificialFrame = i37 % 128;
                int i38 = i37 % 2;
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int iIndexOf5 = 24 - TextUtils.indexOf((CharSequence) "", '0');
                    char cMyPid = (char) ((Process.myPid() >> 22) + 30068);
                    int i39 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 815;
                    byte[] bArr9 = $$d;
                    byte b10 = bArr9[21];
                    Object[] objArr28 = new Object[1];
                    n(b10, (byte) (b10 - 1), (byte) (-bArr9[11]), objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iIndexOf5, cMyPid, i39, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i40 = ((int[]) objArr29[0])[0];
                int i41 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int iIdentityHashCode = System.identityHashCode(this);
                int i42 = ~iIdentityHashCode;
                int i43 = (((((~(1018623958 | i42)) | (~((-137396867) | iIdentityHashCode))) * 988) - 1857740263) + ((((~(iIdentityHashCode | 683054726)) | 335569232) | (~(i42 | (-137396867)))) * 988)) - 771811414;
                int i44 = (i43 << 13) ^ i43;
                int i45 = i44 ^ (i44 >>> 17);
                ((int[]) objArr[3])[0] = i45 ^ (i45 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                o(new char[]{23, 17, 18, 3, 11, '\b', 65535, 20, 65535, 65484, '\n', 65535, '\f', 5, 65484, 65521}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 99, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) - 110, KeyEvent.getDeadChar(0, 0) + 157, false, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                o(new char[]{65534, 65535, 3, 65534, 65535, '\b', 14, 3, 14, 19, 65506, 65531, CharUtils.CR, 2, 65501, '\t'}, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 17, 1 - TextUtils.indexOf((CharSequence) "", '0', 0), 161 - TextUtils.indexOf("", "", 0), false, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, -771811414};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int i46 = 26 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    char maximumDrawingCacheSize = (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 30068);
                    int i47 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 816;
                    byte[] bArr10 = $$d;
                    byte b11 = bArr10[21];
                    Object[] objArr33 = new Object[1];
                    n((byte) (b11 - 1), b11, bArr10[19], objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i46, maximumDrawingCacheSize, i47, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int threadPriority2 = 25 - ((Process.getThreadPriority(0) + 20) >> 6);
                    char c4 = (char) (30069 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                    int i48 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 816;
                    byte[] bArr11 = $$d;
                    byte b12 = bArr11[21];
                    Object[] objArr34 = new Object[1];
                    n(b12, (byte) (b12 - 1), (byte) (-bArr11[11]), objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(threadPriority2, c4, i48, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    o(new char[]{11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f', 0, '\b', 65534}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 18, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 20, (ViewConfiguration.getScrollBarSize() >> 8) + 158, false, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    o(new char[]{5, 65530, '\t', '\f', 65534, 65533, 65515, 65534, 65530, 5, CharUtils.CR, 2, 6, 65534, 65534}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 100, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 35, Gravity.getAbsoluteGravity(0, 0) + 162, false, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int packedPositionChild = 24 - ExpandableListView.getPackedPositionChild(0L);
                        char packedPositionGroup = (char) (30068 - ExpandableListView.getPackedPositionGroup(0L));
                        int iMyPid = 816 - (Process.myPid() >> 22);
                        byte[] bArr12 = $$d;
                        byte b13 = bArr12[21];
                        Object[] objArr37 = new Object[1];
                        n(b13, (byte) (b13 - 1), bArr12[5], objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(packedPositionChild, packedPositionGroup, iMyPid, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            o(new char[]{23, 17, 18, 3, 11, '\b', 65535, 20, 65535, 65484, '\n', 65535, '\f', 5, 65484, 65521}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 99, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) - 110, KeyEvent.getDeadChar(0, 0) + 157, false, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            o(new char[]{65534, 65535, 3, 65534, 65535, '\b', 14, 3, 14, 19, 65506, 65531, CharUtils.CR, 2, 65501, '\t'}, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 17, 1 - TextUtils.indexOf((CharSequence) "", '0', 0), 161 - TextUtils.indexOf("", "", 0), false, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, -771811414};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int i49 = 26 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                char maximumDrawingCacheSize2 = (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 30068);
                int i410 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 816;
                byte[] bArr13 = $$d;
                byte b14 = bArr13[21];
                Object[] objArr311 = new Object[1];
                n((byte) (b14 - 1), b14, bArr13[19], objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i49, maximumDrawingCacheSize2, i410, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int threadPriority3 = 25 - ((Process.getThreadPriority(0) + 20) >> 6);
                char c5 = (char) (30069 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                int i411 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 816;
                byte[] bArr14 = $$d;
                byte b15 = bArr14[21];
                Object[] objArr312 = new Object[1];
                n(b15, (byte) (b15 - 1), (byte) (-bArr14[11]), objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(threadPriority3, c5, i411, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            o(new char[]{11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f', 0, '\b', 65534}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 18, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 20, (ViewConfiguration.getScrollBarSize() >> 8) + 158, false, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            o(new char[]{5, 65530, '\t', '\f', 65534, 65533, 65515, 65534, 65530, 5, CharUtils.CR, 2, 6, 65534, 65534}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 100, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 35, Gravity.getAbsoluteGravity(0, 0) + 162, false, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int packedPositionChild2 = 24 - ExpandableListView.getPackedPositionChild(0L);
                char packedPositionGroup2 = (char) (30068 - ExpandableListView.getPackedPositionGroup(0L));
                int iMyPid2 = 816 - (Process.myPid() >> 22);
                byte[] bArr15 = $$d;
                byte b16 = bArr15[21];
                Object[] objArr315 = new Object[1];
                n(b16, (byte) (b16 - 1), bArr15[5], objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(packedPositionChild2, packedPositionGroup2, iMyPid2, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i50 = ((int[]) objArr[1])[0];
        int i51 = ((int[]) objArr[0])[0];
        if (i51 == i50) {
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i52 = ((int[]) objArr[3])[0];
            int i53 = ((int[]) objArr[0])[0];
            int i54 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
            int i55 = 572687917 + (((~(155735523 | iElapsedRealtime)) | 42436842) * 672);
            int i56 = ~iElapsedRealtime;
            int i57 = i52 + i55 + (((~(iElapsedRealtime | 42436842)) | (~((-155735524) | i56))) * (-672)) + (((~((-42436843) | i56)) | 42436616) * 672);
            int i58 = (i57 << 13) ^ i57;
            int i59 = i58 ^ (i58 >>> 17);
            ((int[]) objArr40[3])[0] = i59 ^ (i59 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            for (String str2 : strArr7) {
                arrayList2.add(str2);
            }
        }
        Object[] objArr41 = {Long.valueOf((((long) (-1592906864)) << 32) ^ ((long) (i50 ^ i51))), Long.valueOf(-1592906863)};
        byte[] bArr16 = $$m;
        byte b17 = bArr16[5];
        Object[] objArr42 = new Object[1];
        m((byte) 81, b17, (byte) (b17 | Utf8.REPLACEMENT_BYTE), objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b18 = bArr16[83];
        Object[] objArr43 = new Object[1];
        m(b18, b18, bArr16[5], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i60 = ((int[]) objArr[3])[0];
        int i61 = ((int[]) objArr[0])[0];
        int i62 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int i63 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().heightPixels;
        int i64 = i60 + ((((-1148354397) + (((~i63) | 466739922) * 1444)) + (((~(i63 | (-201524776))) | ((~(399697141 | i63)) | 134283778)) * (-1444))) - 1978775318);
        int i65 = (i64 << 13) ^ i64;
        int i66 = i65 ^ (i65 >>> 17);
        ((int[]) objArr44[3])[0] = i66 ^ (i66 << 5);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onStart() throws Throwable {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 33;
        artificialFrame = i2 % 128;
        int i3 = i2 % 2;
        super.onStart();
        int i4 = artificialFrame + 63;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
        if (i4 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }
}
