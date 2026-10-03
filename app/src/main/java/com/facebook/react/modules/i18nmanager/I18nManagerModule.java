package com.facebook.react.modules.i18nmanager;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import com.facebook.fbreact.specs.NativeI18nManagerSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import o.artificialFrame;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@ReactModule(name = "I18nManager")
public final class I18nManagerModule extends NativeI18nManagerSpec {
    public static final Companion Companion = new Companion(null);
    public static final String NAME = "I18nManager";

    public I18nManagerModule(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.fbreact.specs.NativeI18nManagerSpec
    public Map<String, Object> getTypedExportedConstants() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Locale locale = reactApplicationContext.getResources().getConfiguration().getLocales().get(0);
        I18nUtil.Companion companion = I18nUtil.Companion;
        I18nUtil companion2 = companion.getInstance();
        Intrinsics.checkNotNull(reactApplicationContext);
        return MapsKt__MapsKt.mapOf(TuplesKt.to("isRTL", Boolean.valueOf(companion2.isRTL(reactApplicationContext))), TuplesKt.to("doLeftAndRightSwapInRTL", Boolean.valueOf(companion.getInstance().doLeftAndRightSwapInRTL(reactApplicationContext))), TuplesKt.to("localeIdentifier", locale.toString()));
    }

    @Override // com.facebook.fbreact.specs.NativeI18nManagerSpec
    public void allowRTL(boolean z) {
        I18nUtil companion = I18nUtil.Companion.getInstance();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        companion.allowRTL(reactApplicationContext, z);
    }

    @Override // com.facebook.fbreact.specs.NativeI18nManagerSpec
    public void forceRTL(boolean z) {
        I18nUtil companion = I18nUtil.Companion.getInstance();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        companion.forceRTL(reactApplicationContext, z);
    }

    @Override // com.facebook.fbreact.specs.NativeI18nManagerSpec
    public void swapLeftAndRightInRTL(boolean z) {
        I18nUtil companion = I18nUtil.Companion.getInstance();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        companion.swapLeftAndRightInRTL(reactApplicationContext, z);
    }

    public static final class Companion {
        private static final byte[] $$c = {102, -25, -78, -11};
        private static final int $$d = 58;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {67, 87, 59, -10, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4, 50, Ascii.SO, -50};
        private static final int $$b = 240;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static int[] ICustomTabsCallbackStub = {-168619596, -417370964, 1479618885, 218236489, 1036755196, -878158834, -620863620, 1362224997, 915654564, 715821234, 655709530, -813171815, -976130223, -396152372, 352722772, 881671874, 1581068779, -239695953};

        /* JADX WARN: Code duplicated, block: B:10:0x0026  */
        /* JADX WARN: Code duplicated, block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(int r6, byte r7, byte r8) {
            /*
                int r6 = r6 * 6
                int r6 = r6 + 109
                int r8 = r8 * 4
                int r8 = r8 + 1
                byte[] r0 = com.facebook.react.modules.i18nmanager.I18nManagerModule.Companion.$$c
                int r7 = r7 * 3
                int r7 = 3 - r7
                byte[] r1 = new byte[r8]
                r2 = 0
                if (r0 != 0) goto L16
                r3 = r7
                r4 = r2
                goto L2d
            L16:
                r3 = r2
            L17:
                int r7 = r7 + 1
                byte r4 = (byte) r6
                r1[r3] = r4
                int r3 = r3 + 1
                if (r3 != r8) goto L26
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L26:
                r4 = r0[r7]
                r5 = r7
                r7 = r6
                r6 = r4
                r4 = r3
                r3 = r5
            L2d:
                int r6 = -r6
                int r6 = r6 + r7
                r7 = r3
                r3 = r4
                goto L17
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.i18nmanager.I18nManagerModule.Companion.$$e(int, byte, byte):java.lang.String");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0021  */
        /* JADX WARN: Code duplicated, block: B:8:0x0019  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0023). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void b(byte r6, short r7, int r8, java.lang.Object[] r9) {
            /*
                int r7 = 28 - r7
                int r6 = r6 + 4
                int r8 = 115 - r8
                byte[] r0 = com.facebook.react.modules.i18nmanager.I18nManagerModule.Companion.$$a
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L11
                r3 = r6
                r8 = r7
                r4 = r2
                goto L23
            L11:
                r3 = r2
            L12:
                int r4 = r3 + 1
                byte r5 = (byte) r8
                r1[r3] = r5
                if (r4 != r7) goto L21
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L21:
                r3 = r0[r6]
            L23:
                int r6 = r6 + 1
                int r8 = r8 + r3
                int r8 = r8 + (-5)
                r3 = r4
                goto L12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.i18nmanager.I18nManagerModule.Companion.b(byte, short, int, java.lang.Object[]):void");
        }

        private Companion() {
        }

        private static void a(int i, int[] iArr, Object[] objArr) throws Throwable {
            int i2;
            int i3 = 2 % 2;
            artificialFrame artificialframe = new artificialFrame();
            char[] cArr = new char[4];
            char[] cArr2 = new char[iArr.length * 2];
            int[] iArr2 = ICustomTabsCallbackStub;
            int i4 = -1780896814;
            int i5 = 16;
            int i6 = 1;
            int i7 = 0;
            if (iArr2 != null) {
                int i8 = $11 + 101;
                $10 = i8 % 128;
                int i9 = i8 % 2;
                int length = iArr2.length;
                int[] iArr3 = new int[length];
                int i10 = 0;
                while (i10 < length) {
                    int i11 = $11 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                    $10 = i11 % 128;
                    int i12 = i11 % 2;
                    try {
                        Object[] objArr2 = {Integer.valueOf(iArr2[i10])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) 0;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getPressedStateDuration() >> i5), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1), 1562 - (ViewConfiguration.getPressedStateDuration() >> 16), 180153818, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                        }
                        iArr3[i10] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                        i10++;
                        i4 = -1780896814;
                        i5 = 16;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                iArr2 = iArr3;
            }
            int length2 = iArr2.length;
            int[] iArr4 = new int[length2];
            int[] iArr5 = ICustomTabsCallbackStub;
            char c = '0';
            if (iArr5 != null) {
                int length3 = iArr5.length;
                int[] iArr6 = new int[length3];
                int i13 = 0;
                while (i13 < length3) {
                    int i14 = $11 + b.f40o;
                    $10 = i14 % 128;
                    int i15 = i14 % 2;
                    Object[] objArr3 = new Object[i6];
                    objArr3[i7] = Integer.valueOf(iArr5[i13]);
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                    if (objAccessartificialFrame2 == null) {
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, i7) + 11;
                        char cLastIndexOf = (char) (TextUtils.lastIndexOf("", c, i7) + 1);
                        int iRgb = Color.rgb(i7, i7, i7) + 16778778;
                        byte b3 = (byte) i7;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, cLastIndexOf, iRgb, 180153818, false, $$e(b3, b4, b4), new Class[]{Integer.TYPE});
                    }
                    iArr6[i13] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                    i13++;
                    c = '0';
                    i6 = 1;
                    i7 = 0;
                }
                i2 = i7;
                iArr5 = iArr6;
            } else {
                i2 = 0;
            }
            System.arraycopy(iArr5, i2, iArr4, i2, length2);
            artificialframe.e = i2;
            int i16 = $10 + 41;
            $11 = i16 % 128;
            int i17 = i16 % 2;
            while (artificialframe.e < iArr.length) {
                cArr[0] = (char) (iArr[artificialframe.e] >> 16);
                cArr[1] = (char) iArr[artificialframe.e];
                cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
                cArr[3] = (char) iArr[artificialframe.e + 1];
                artificialframe.c = (cArr[0] << 16) + cArr[1];
                artificialframe.b = (cArr[2] << 16) + cArr[3];
                artificialFrame.coroutineBoundary(iArr4);
                int i18 = $10 + 37;
                $11 = i18 % 128;
                if (i18 % 2 == 0) {
                    int i19 = 4 % 3;
                }
                for (int i20 = 0; i20 < 16; i20++) {
                    artificialframe.c ^= iArr4[i20];
                    Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 1;
                        byte b6 = (byte) (b5 - 1);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(26 - View.combineMeasuredStates(0, 0), (char) TextUtils.getCapsMode("", 0, 0), 1041 - TextUtils.indexOf("", "", 0), 995482881, false, $$e(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                    }
                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                    artificialframe.c = artificialframe.b;
                    artificialframe.b = iIntValue;
                }
                int i21 = artificialframe.c;
                artificialframe.c = artificialframe.b;
                artificialframe.b = i21;
                artificialframe.b ^= iArr4[16];
                artificialframe.c ^= iArr4[17];
                int i22 = artificialframe.c;
                int i23 = artificialframe.b;
                cArr[0] = (char) (artificialframe.c >>> 16);
                cArr[1] = (char) artificialframe.c;
                cArr[2] = (char) (artificialframe.b >>> 16);
                cArr[3] = (char) artificialframe.b;
                artificialFrame.coroutineBoundary(iArr4);
                cArr2[artificialframe.e * 2] = cArr[0];
                cArr2[(artificialframe.e * 2) + 1] = cArr[1];
                cArr2[(artificialframe.e * 2) + 2] = cArr[2];
                cArr2[(artificialframe.e * 2) + 3] = cArr[3];
                Object[] objArr5 = {artificialframe, artificialframe};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1348396126);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(37 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) ((KeyEvent.getMaxKeyCode() >> 16) + 28010), TextUtils.lastIndexOf("", '0', 0, 0) + 307, -818175402, false, "q", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
            objArr[0] = new String(cArr2, 0, i);
        }

        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r32, int r33, int r34, int r35) {
            /*
                Method dump skipped, instruction units count: 3002
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.i18nmanager.I18nManagerModule.Companion.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
        }
    }
}
