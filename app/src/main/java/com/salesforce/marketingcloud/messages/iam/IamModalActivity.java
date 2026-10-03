package com.salesforce.marketingcloud.messages.iam;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.R;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import o.ArtificialStackFrames;
import o.build;

/* JADX INFO: loaded from: classes3.dex */
public class IamModalActivity extends f implements View.OnClickListener {
    private static final byte[] $$c = {32, -58, -29, Ascii.ETB};
    private static final int $$f = 146;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$d = {92, 127, 52, -8, -5, -6, -21, -9, -5, 52, -4, -68, -14, -15, 6, -22, -5, 4, -20, 53, -75, -5, 2, -28, 5, -18, -12, -4, 54, -60, -22, 1, -23, -6, -3, -4, 45, -31, -42, -10, -8, -22, -9, 4, -8, 8, -37, 3, -17, -3, -24, 42, -44, -6, -24, -13, 6, -22, -9, -70, -21, -7, 54, -65, -4, -11, -11, -6, -22, -9, -5, 52, -68, -13, 3, -15, -7, -20, -2, -16, 2, -16, -6, -14, 0, 46, -62, -21, -12, 4, 46, -43, -43, -6, 2, -26, 9, -11, -22, Ascii.SYN, -27, -21, -13, 7, -18, 2, -11, Ascii.SYN, -36, -11, -26, -4, -12, -16, 76, -40, -53, -7, -12, 6, -22, -4, -15, -8};
    private static final int $$e = 129;
    private static final byte[] $$a = {72, -88, 5, 32, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR};
    private static final int $$b = 48;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char TopicBuilder = 63771;
    private static char ICustomTabsCallback = 20784;
    private static char extraCallbackWithResult = 31289;
    private static char onMessageChannelReady = 8676;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[InAppMessage.LayoutOrder.values().length];
            a = iArr;
            try {
                iArr[InAppMessage.LayoutOrder.ImageTitleBody.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[InAppMessage.LayoutOrder.TitleImageBody.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$i(int r6, short r7, byte r8) {
        /*
            int r8 = r8 * 2
            int r8 = r8 + 108
            byte[] r0 = com.salesforce.marketingcloud.messages.iam.IamModalActivity.$$c
            int r6 = r6 * 2
            int r6 = 3 - r6
            int r7 = r7 * 3
            int r7 = 1 - r7
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r7
            r4 = r2
            goto L28
        L16:
            r3 = r2
        L17:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            int r6 = r6 + 1
            if (r4 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L26:
            r3 = r0[r6]
        L28:
            int r3 = -r3
            int r8 = r8 + r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.iam.IamModalActivity.$$i(int, short, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void h(byte r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.salesforce.marketingcloud.messages.iam.IamModalActivity.$$d
            int r7 = r7 * 2
            int r1 = 65 - r7
            int r8 = r8 + 4
            int r6 = r6 + 36
            byte[] r1 = new byte[r1]
            int r7 = 64 - r7
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r8
            r4 = r2
            goto L2c
        L14:
            r3 = r2
        L15:
            int r8 = r8 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L2c:
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + (-9)
            r8 = r3
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.iam.IamModalActivity.h(byte, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0034). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void i(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 8
            int r8 = 19 - r8
            int r7 = r7 * 28
            int r7 = r7 + 84
            byte[] r0 = com.salesforce.marketingcloud.messages.iam.IamModalActivity.$$a
            int r6 = r6 * 3
            int r1 = 12 - r6
            byte[] r1 = new byte[r1]
            int r6 = 11 - r6
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r8
            r4 = r2
            goto L34
        L18:
            r3 = r2
        L19:
            r5 = r8
            r8 = r7
            r7 = r5
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            int r7 = r7 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r5
        L34:
            int r7 = r7 + r3
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.iam.IamModalActivity.i(byte, int, short, java.lang.Object[]):void");
    }

    protected int a(InAppMessage inAppMessage) {
        int i = R.layout.mcsdk_iam_modal_inset_itb;
        InAppMessage.Media media = inAppMessage.media();
        int i2 = a.a[inAppMessage.layoutOrder().ordinal()];
        if (i2 == 1) {
            return (media == null || media.size() != InAppMessage.Media.ImageSize.e2e) ? R.layout.mcsdk_iam_modal_inset_itb : R.layout.mcsdk_iam_modal_e2e_itb;
        }
        if (i2 != 2) {
            return i;
        }
        return (media == null || media.size() != InAppMessage.Media.ImageSize.e2e) ? R.layout.mcsdk_iam_modal_inset_tib : R.layout.mcsdk_iam_modal_e2e_tib;
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

    @Override // com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (isFinishing()) {
            return;
        }
        setContentView(a(c().l()));
        new l(this, c().s()).a(findViewById(android.R.id.content), c());
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
        int i2 = artificialFrame + 45;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
        if (objAccessartificialFrame == null) {
            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionType(0L) + 30, (char) (49993 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), ExpandableListView.getPackedPositionType(0L) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj = ((Field) objAccessartificialFrame).get(null);
        try {
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579113874);
            if (objAccessartificialFrame2 == null) {
                int iLastIndexOf = 29 - TextUtils.lastIndexOf("", '0', 0, 0);
                char jumpTapTimeout = (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 49993);
                int i4 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 74;
                byte[] bArr = $$d;
                byte b = (byte) (-bArr[86]);
                Object[] objArr = new Object[1];
                h(b, (byte) (b & 224), (byte) (-bArr[31]), objArr);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, jumpTapTimeout, i4, -1048962150, false, (String) objArr[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame2).invoke(obj, null);
            super.onResume();
            int i5 = artificialFrame + 43;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
            int i6 = i5 % 2;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() throws Throwable {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 93;
        artificialFrame = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(KeyEvent.getDeadChar(0, 0) + 30, (char) (TextUtils.getCapsMode("", 0, 0) + 49993), 74 - TextUtils.getTrimmedLength(""), -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
                }
                Object obj = ((Field) objAccessartificialFrame).get(null);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579114835);
                if (objAccessartificialFrame2 == null) {
                    int iAlpha = Color.alpha(0) + 30;
                    char defaultSize = (char) (49993 - View.getDefaultSize(0, 0));
                    int iResolveOpacity = 74 - Drawable.resolveOpacity(0, 0);
                    byte b = (byte) 63;
                    Object[] objArr = new Object[1];
                    h(b, (byte) (b & 224), (byte) (-$$d[31]), objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iAlpha, defaultSize, iResolveOpacity, -1048959141, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj, null);
                super.onPause();
                int i3 = 87 / 0;
                return;
            }
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(949068051);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(Gravity.getAbsoluteGravity(0, 0) + 30, (char) (49993 - (KeyEvent.getMaxKeyCode() >> 16)), ((byte) KeyEvent.getModifierMetaStateMask()) + 75, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
            }
            Object obj2 = ((Field) objAccessartificialFrame3).get(null);
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579114835);
            if (objAccessartificialFrame4 == null) {
                int iBlue = Color.blue(0) + 30;
                char cBlue = (char) (49993 - Color.blue(0));
                int packedPositionType = 74 - ExpandableListView.getPackedPositionType(0L);
                byte b2 = (byte) 63;
                Object[] objArr2 = new Object[1];
                h(b2, (byte) (b2 & 224), (byte) (-$$d[31]), objArr2);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iBlue, cBlue, packedPositionType, -1048959141, false, (String) objArr2[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame4).invoke(obj2, null);
            super.onPause();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    private static void j(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        build buildVar = new build();
        char[] cArr2 = new char[cArr.length];
        int i3 = 0;
        buildVar.c = 0;
        char[] cArr3 = new char[2];
        while (buildVar.c < cArr.length) {
            int i4 = $10 + 43;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            cArr3[i3] = cArr[buildVar.c];
            cArr3[1] = cArr[buildVar.c + 1];
            int i6 = $11 + 17;
            $10 = i6 % 128;
            int i7 = i6 % 2;
            int i8 = 58224;
            int i9 = i3;
            while (i9 < 16) {
                char c = cArr3[1];
                char c2 = cArr3[i3];
                char[] cArr4 = cArr3;
                try {
                    Object[] objArr2 = {Integer.valueOf(c), Integer.valueOf((c2 + i8) ^ ((c2 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))))), Integer.valueOf(c2 >>> 5), Integer.valueOf(onMessageChannelReady)};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(28 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 17263), (ViewConfiguration.getTouchSlop() >> 8) + 1067, 1042277788, false, $$i(b, b2, b2), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    char cCharValue = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    cArr4[1] = cCharValue;
                    Object[] objArr3 = {Integer.valueOf(cArr4[0]), Integer.valueOf((cCharValue + i8) ^ ((cCharValue << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L))))), Integer.valueOf(cCharValue >>> 5), Integer.valueOf(ICustomTabsCallback)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0) + 28, (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 17263), 1066 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 1042277788, false, $$i(b3, b4, b4), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[0] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i8 -= 40503;
                    i9++;
                    cArr3 = cArr4;
                    i3 = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            char[] cArr5 = cArr3;
            cArr2[buildVar.c] = cArr5[0];
            cArr2[buildVar.c + 1] = cArr5[1];
            Object[] objArr4 = {buildVar, buildVar};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1010141908);
            if (objAccessartificialFrame3 == null) {
                byte b5 = (byte) 0;
                byte b6 = b5;
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(Color.argb(0, 0, 0, 0) + 25, (char) (ExpandableListView.getPackedPositionType(0L) + 63928), 486 - Color.blue(0), 1554985764, false, $$i(b5, b6, (byte) (b6 + 1)), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            cArr3 = cArr5;
            i3 = 0;
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:16:0x0242 A[Catch: all -> 0x09dc, TryCatch #2 {all -> 0x09dc, blocks: (B:51:0x06b4, B:53:0x06d4, B:54:0x071b, B:14:0x022e, B:16:0x0242, B:17:0x0274), top: B:101:0x022e }] */
    /* JADX WARN: Code duplicated, block: B:20:0x028a  */
    /* JADX WARN: Code duplicated, block: B:25:0x0317  */
    /* JADX WARN: Code duplicated, block: B:50:0x0656  */
    /* JADX WARN: Code duplicated, block: B:53:0x06d4 A[Catch: all -> 0x09dc, TryCatch #2 {all -> 0x09dc, blocks: (B:51:0x06b4, B:53:0x06d4, B:54:0x071b, B:14:0x022e, B:16:0x0242, B:17:0x0274), top: B:101:0x022e }] */
    /* JADX WARN: Code duplicated, block: B:57:0x072d  */
    /* JADX WARN: Code duplicated, block: B:62:0x07dd  */
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
            int absoluteGravity = 26 - Gravity.getAbsoluteGravity(0, 0);
            char doubleTapTimeout = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
            int iResolveSize = View.resolveSize(0, 0) + 1041;
            byte[] bArr = $$a;
            byte b = bArr[21];
            Object[] objArr2 = new Object[1];
            i(b, b, (byte) (-bArr[8]), objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(absoluteGravity, doubleTapTimeout, iResolveSize, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            int i2 = artificialFrame + 1;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
            int i3 = i2 % 2;
            long j2 = j + 4611686018427387864L;
            Object[] objArr3 = new Object[1];
            j(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 18, new char[]{31022, 12671, 20583, 37757, 45367, 45465, 52107, 28456, 42435, 10713, 62419, 19386, 6443, 36476, 29283, 43438, 59019, 26074, 383, 5465, 49620, 45767}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            j(14 - TextUtils.lastIndexOf("", '0'), new char[]{65324, 31704, 32763, 4524, 13726, 17535, 11792, 64944, 4033, 47191, 36983, 28294, 7637, 42165, 43355, 50444}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int iNormalizeMetaState = 26 - KeyEvent.normalizeMetaState(0);
                    char cAlpha = (char) Color.alpha(0);
                    int i4 = 1042 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    byte b2 = $$a[21];
                    byte b3 = b2;
                    Object[] objArr5 = new Object[1];
                    i(b2, b3, b3, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, cAlpha, i4, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i5 = ((int[]) objArr6[3])[0];
                int i6 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) + 2095322655;
                int i7 = ~((-300257359) | iCodePointAt);
                int i8 = ~iCodePointAt;
                int i9 = ((((-108836114) + ((i7 | (~((-222153552) | i8))) * (-1808))) + (((~((-281022465) | iCodePointAt)) | (~(i8 | (-202918658)))) * TypedValues.Custom.TYPE_BOOLEAN)) + ((((~(iCodePointAt | 222153551)) | 19234894) | (~(300257358 | i8))) * TypedValues.Custom.TYPE_BOOLEAN)) - 401137137;
                int i10 = (i9 << 13) ^ i9;
                int i11 = i10 ^ (i10 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i11 ^ (i11 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                j(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{986, 31251, 26884, 29302, 61708, 35186, 31022, 12671, 28472, 14816, 38541, 52858, 22113, 46721, 22427, 47311}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                j(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 33, new char[]{62414, 19025, 37042, 3345, 15417, 1444, 9695, 42856, 42878, 21190, 39061, 53944, 40946, 41725, 40018, 3595}, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {-831833966};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 22251), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1034, 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), -401137137, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 26;
                        char cLastIndexOf = (char) ((-1) - TextUtils.lastIndexOf("", '0', 0));
                        int iResolveSizeAndState = 1041 - View.resolveSizeAndState(0, 0, 0);
                        byte b4 = $$a[21];
                        byte b5 = b4;
                        Object[] objArr10 = new Object[1];
                        i(b4, b5, b5, objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, cLastIndexOf, iResolveSizeAndState, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        j((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 21, new char[]{31022, 12671, 20583, 37757, 45367, 45465, 52107, 28456, 42435, 10713, 62419, 19386, 6443, 36476, 29283, 43438, 59019, 26074, 383, 5465, 49620, 45767}, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        j(15 - (ViewConfiguration.getTouchSlop() >> 8), new char[]{65324, 31704, 32763, 4524, 13726, 17535, 11792, 64944, 4033, 47191, 36983, 28294, 7637, 42165, 43355, 50444}, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int offsetBefore = 26 - TextUtils.getOffsetBefore("", 0);
                            char c = (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                            int minimumFlingVelocity = 1041 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                            byte[] bArr2 = $$a;
                            byte b6 = bArr2[21];
                            Object[] objArr13 = new Object[1];
                            i(b6, b6, (byte) (-bArr2[8]), objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(offsetBefore, c, minimumFlingVelocity, 2061780482, false, (String) objArr13[0], null);
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
            j(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{986, 31251, 26884, 29302, 61708, 35186, 31022, 12671, 28472, 14816, 38541, 52858, 22113, 46721, 22427, 47311}, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            j(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 33, new char[]{62414, 19025, 37042, 3345, 15417, 1444, 9695, 42856, 42878, 21190, 39061, 53944, 40946, 41725, 40018, 3595}, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {-831833966};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 22251), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1034, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), -401137137, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int iResolveOpacity2 = Drawable.resolveOpacity(0, 0) + 26;
                char cLastIndexOf2 = (char) ((-1) - TextUtils.lastIndexOf("", '0', 0));
                int iResolveSizeAndState2 = 1041 - View.resolveSizeAndState(0, 0, 0);
                byte b7 = $$a[21];
                byte b8 = b7;
                Object[] objArr17 = new Object[1];
                i(b7, b8, b8, objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iResolveOpacity2, cLastIndexOf2, iResolveSizeAndState2, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            j((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 21, new char[]{31022, 12671, 20583, 37757, 45367, 45465, 52107, 28456, 42435, 10713, 62419, 19386, 6443, 36476, 29283, 43438, 59019, 26074, 383, 5465, 49620, 45767}, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            j(15 - (ViewConfiguration.getTouchSlop() >> 8), new char[]{65324, 31704, 32763, 4524, 13726, 17535, 11792, 64944, 4033, 47191, 36983, 28294, 7637, 42165, 43355, 50444}, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int offsetBefore2 = 26 - TextUtils.getOffsetBefore("", 0);
                char c2 = (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                int minimumFlingVelocity2 = 1041 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                byte[] bArr3 = $$a;
                byte b9 = bArr3[21];
                Object[] objArr110 = new Object[1];
                i(b9, b9, (byte) (-bArr3[8]), objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(offsetBefore2, c2, minimumFlingVelocity2, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i12 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i13 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i13 == i12) {
            int i14 = artificialFrame + 27;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i14 % 128;
            int i15 = i14 % 2;
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i16 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i17 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i18 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode = System.identityHashCode(this);
            int i19 = ~iIdentityHashCode;
            int i20 = i16 + ((((-1088259046) + (((~(229444198 | i19)) | (~((-307548006) | iIdentityHashCode))) * (-370))) + ((((~(iIdentityHashCode | 229444198)) | (~(i19 | (-307548006)))) | 229179394) * (-370))) - 1102970140);
            int i21 = (i20 << 13) ^ i20;
            int i22 = i21 ^ (i21 >>> 17);
            ((int[]) objArr20[1])[0] = i22 ^ (i22 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    int i23 = getARTIFICIAL_FRAME_PACKAGE_NAME + 15;
                    artificialFrame = i23 % 128;
                    int i24 = i23 % 2;
                    arrayList.add(str);
                }
            }
            long j3 = (((long) 965289981) << 32) ^ ((long) (i12 ^ i13));
            long j4 = 965289983;
            int i25 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
            artificialFrame = i25 % 128;
            int i26 = i25 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr4 = $$d;
                Object[] objArr22 = new Object[1];
                h((byte) (-bArr4[20]), bArr4[24], (byte) (-bArr4[31]), objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                h(bArr4[84], (byte) (-bArr4[37]), bArr4[19], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i27 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i28 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i29 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                int i30 = i27 + (-823567798) + (((~(607443006 | iElapsedRealtime)) | (-685546814)) * (-964)) + (((~((~iElapsedRealtime) | 607443006)) | (-754769216)) * (-964));
                int i31 = (i30 << 13) ^ i30;
                int i32 = i31 ^ (i31 >>> 17);
                ((int[]) objArr24[1])[0] = i32 ^ (i32 << 5);
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
            int iIndexOf = 24 - TextUtils.indexOf((CharSequence) "", '0');
            char defaultSize = (char) (View.getDefaultSize(0, 0) + 30068);
            int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 816;
            byte[] bArr5 = $$a;
            byte b10 = bArr5[21];
            Object[] objArr25 = new Object[1];
            i(b10, b10, (byte) (-bArr5[8]), objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iIndexOf, defaultSize, maxKeyCode, 721586079, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 != -1) {
            long j6 = j5 + 1885;
            Object[] objArr26 = new Object[1];
            j(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{31022, 12671, 20583, 37757, 45367, 45465, 52107, 28456, 42435, 10713, 62419, 19386, 6443, 36476, 29283, 43438, 59019, 26074, 383, 5465, 49620, 45767}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            j(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 34, new char[]{65324, 31704, 32763, 4524, 13726, 17535, 11792, 64944, 4033, 47191, 36983, 28294, 7637, 42165, 43355, 50444}, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i33 = artificialFrame + 59;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i33 % 128;
                int i34 = i33 % 2;
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int i35 = 25 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                    char c3 = (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 30068);
                    int i36 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 815;
                    byte b11 = $$a[21];
                    byte b12 = b11;
                    Object[] objArr28 = new Object[1];
                    i(b11, b12, b12, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i35, c3, i36, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i37 = ((int[]) objArr29[0])[0];
                int i38 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int i39 = ~(Process.myUid() | 135404591);
                int i40 = ((((196075185 | i39) * (-658)) - 1589892193) + ((i39 | 61719184) * 658)) - 1925777609;
                int i41 = (i40 << 13) ^ i40;
                int i42 = i41 ^ (i41 >>> 17);
                ((int[]) objArr[3])[0] = i42 ^ (i42 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                j(16 - TextUtils.indexOf("", ""), new char[]{986, 31251, 26884, 29302, 61708, 35186, 31022, 12671, 28472, 14816, 38541, 52858, 22113, 46721, 22427, 47311}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                j(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{62414, 19025, 37042, 3345, 15417, 1444, 9695, 42856, 42878, 21190, 39061, 53944, 40946, 41725, 40018, 3595}, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, -1925777609};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 25;
                    char doubleTapTimeout2 = (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 30068);
                    int trimmedLength = TextUtils.getTrimmedLength("") + 816;
                    byte b13 = (byte) ($$a[21] - 1);
                    byte b14 = b13;
                    Object[] objArr33 = new Object[1];
                    i(b13, b14, b14, objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString, doubleTapTimeout2, trimmedLength, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0', 0) + 26;
                    char cAlpha2 = (char) (Color.alpha(0) + 30068);
                    int iNormalizeMetaState2 = KeyEvent.normalizeMetaState(0) + 816;
                    byte b15 = $$a[21];
                    byte b16 = b15;
                    Object[] objArr34 = new Object[1];
                    i(b15, b16, b16, objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf2, cAlpha2, iNormalizeMetaState2, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    j(TextUtils.getOffsetBefore("", 0) + 22, new char[]{31022, 12671, 20583, 37757, 45367, 45465, 52107, 28456, 42435, 10713, 62419, 19386, 6443, 36476, 29283, 43438, 59019, 26074, 383, 5465, 49620, 45767}, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    j(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 22, new char[]{65324, 31704, 32763, 4524, 13726, 17535, 11792, 64944, 4033, 47191, 36983, 28294, 7637, 42165, 43355, 50444}, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int i43 = 26 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                        char offsetBefore3 = (char) (30068 - TextUtils.getOffsetBefore("", 0));
                        int i44 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 816;
                        byte[] bArr6 = $$a;
                        byte b17 = bArr6[21];
                        Object[] objArr37 = new Object[1];
                        i(b17, b17, (byte) (-bArr6[8]), objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i43, offsetBefore3, i44, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            j(16 - TextUtils.indexOf("", ""), new char[]{986, 31251, 26884, 29302, 61708, 35186, 31022, 12671, 28472, 14816, 38541, 52858, 22113, 46721, 22427, 47311}, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            j(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{62414, 19025, 37042, 3345, 15417, 1444, 9695, 42856, 42878, 21190, 39061, 53944, 40946, 41725, 40018, 3595}, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, -1925777609};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int iKeyCodeFromString2 = KeyEvent.keyCodeFromString("") + 25;
                char doubleTapTimeout3 = (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 30068);
                int trimmedLength2 = TextUtils.getTrimmedLength("") + 816;
                byte b18 = (byte) ($$a[21] - 1);
                byte b19 = b18;
                Object[] objArr311 = new Object[1];
                i(b18, b19, b19, objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString2, doubleTapTimeout3, trimmedLength2, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0', 0) + 26;
                char cAlpha3 = (char) (Color.alpha(0) + 30068);
                int iNormalizeMetaState3 = KeyEvent.normalizeMetaState(0) + 816;
                byte b110 = $$a[21];
                byte b111 = b110;
                Object[] objArr312 = new Object[1];
                i(b110, b111, b111, objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf3, cAlpha3, iNormalizeMetaState3, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            j(TextUtils.getOffsetBefore("", 0) + 22, new char[]{31022, 12671, 20583, 37757, 45367, 45465, 52107, 28456, 42435, 10713, 62419, 19386, 6443, 36476, 29283, 43438, 59019, 26074, 383, 5465, 49620, 45767}, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            j(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 22, new char[]{65324, 31704, 32763, 4524, 13726, 17535, 11792, 64944, 4033, 47191, 36983, 28294, 7637, 42165, 43355, 50444}, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int i45 = 26 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                char offsetBefore4 = (char) (30068 - TextUtils.getOffsetBefore("", 0));
                int i46 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 816;
                byte[] bArr7 = $$a;
                byte b112 = bArr7[21];
                Object[] objArr315 = new Object[1];
                i(b112, b112, (byte) (-bArr7[8]), objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i45, offsetBefore4, i46, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i47 = ((int[]) objArr[1])[0];
        int i48 = ((int[]) objArr[0])[0];
        if (i48 == i47) {
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i49 = ((int[]) objArr[3])[0];
            int i50 = ((int[]) objArr[0])[0];
            int i51 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int i52 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1182434289;
            int i53 = i49 + (-521189582) + ((~(484245470 | i52)) * 623) + (((~i52) | 135060620) * (-623)) + (((~(i52 | 408739228)) | (~(210566862 | i52)) | (-484245471)) * 623);
            int i54 = (i53 << 13) ^ i53;
            int i55 = i54 ^ (i54 >>> 17);
            ((int[]) objArr40[3])[0] = i55 ^ (i55 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr7 = (String[]) objArr[2];
            if (strArr7 != null) {
                int i56 = getARTIFICIAL_FRAME_PACKAGE_NAME + 33;
                artificialFrame = i56 % 128;
                for (int i57 = i56 % 2 == 0 ? 1 : 0; i57 < strArr7.length; i57++) {
                    int i58 = getARTIFICIAL_FRAME_PACKAGE_NAME + 39;
                    artificialFrame = i58 % 128;
                    int i59 = i58 % 2;
                    arrayList2.add(strArr7[i57]);
                }
            }
            long j7 = ((long) (i47 ^ i48)) ^ (((long) (-716311444)) << 32);
            long j8 = -716311443;
            int i60 = artificialFrame + 101;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i60 % 128;
            int i61 = i60 % 2;
            Object[] objArr41 = {Long.valueOf(j7), Long.valueOf(j8)};
            byte[] bArr8 = $$d;
            byte b20 = bArr8[84];
            Object[] objArr42 = new Object[1];
            h((byte) 63, b20, (byte) (b20 | 55), objArr42);
            Class<?> cls12 = Class.forName((String) objArr42[0]);
            Object[] objArr43 = new Object[1];
            h(bArr8[84], (byte) (-bArr8[37]), bArr8[19], objArr43);
            cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
            Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i62 = ((int[]) objArr[3])[0];
            int i63 = ((int[]) objArr[0])[0];
            int i64 = ((int[]) objArr[1])[0];
            String[] strArr8 = (String[]) objArr[2];
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i65 = ~iFreeMemory;
            int i66 = i62 + (-96127354) + ((~(63086074 | i65)) * 979) + ((iFreeMemory | 261258440) * (-979)) + (((~(iFreeMemory | 63086074)) | (~(i65 | 261258440))) * 979);
            int i67 = (i66 << 13) ^ i66;
            int i68 = i67 ^ (i67 >>> 17);
            ((int[]) objArr44[3])[0] = i68 ^ (i68 << 5);
        }
        int i69 = getARTIFICIAL_FRAME_PACKAGE_NAME + 63;
        artificialFrame = i69 % 128;
        if (i69 % 2 == 0) {
            int i70 = 19 / 0;
        }
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onStart() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 33;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        super.onStart();
        if (i3 != 0) {
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        int i4 = artificialFrame + com.salesforce.marketingcloud.analytics.stats.b.i;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
        int i5 = i4 % 2;
    }
}
