package com.google.android.material.color.utilities;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.function.Function;
import o.ArtificialStackFrames;
import o._CREATION;
import o.artificialFrame;
import o.onNavigationEvent;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes5.dex */
public final class MaterialDynamicColors {
    public DynamicColor highestSurface(@NonNull DynamicScheme dynamicScheme) {
        return dynamicScheme.isDark ? surfaceBright() : surfaceDim();
    }

    public DynamicColor primaryPaletteKeyColor() {
        return DynamicColor.fromPalette("primary_palette_key_color", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda18
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).primaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda19
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$primaryPaletteKeyColor$1((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$primaryPaletteKeyColor$1(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.primaryPalette.getKeyColor().getTone());
    }

    public DynamicColor secondaryPaletteKeyColor() {
        return DynamicColor.fromPalette("secondary_palette_key_color", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda24
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).secondaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda25
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$secondaryPaletteKeyColor$3((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$secondaryPaletteKeyColor$3(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.secondaryPalette.getKeyColor().getTone());
    }

    public DynamicColor tertiaryPaletteKeyColor() {
        return DynamicColor.fromPalette("tertiary_palette_key_color", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda35
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).tertiaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda36
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$tertiaryPaletteKeyColor$5((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$tertiaryPaletteKeyColor$5(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.tertiaryPalette.getKeyColor().getTone());
    }

    public DynamicColor neutralPaletteKeyColor() {
        return DynamicColor.fromPalette("neutral_palette_key_color", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda10
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda11
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$neutralPaletteKeyColor$7((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$neutralPaletteKeyColor$7(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.neutralPalette.getKeyColor().getTone());
    }

    public DynamicColor neutralVariantPaletteKeyColor() {
        return DynamicColor.fromPalette("neutral_variant_palette_key_color", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda83
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralVariantPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda84
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$neutralVariantPaletteKeyColor$9((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$neutralVariantPaletteKeyColor$9(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.neutralVariantPalette.getKeyColor().getTone());
    }

    public DynamicColor background() {
        return new DynamicColor(AppStateModule.APP_STATE_BACKGROUND, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda43
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda44
            private static final byte[] $$c = {4, Ascii.VT, 101, -73};
            private static final int $$d = 226;
            private static int $10 = 0;
            private static int $11 = 1;
            private static final byte[] $$a = {Ascii.RS, -66, -95, 114, -12, -6, Ascii.ESC, -22, -26, 4, -12, 0, -8, -2, -8};
            private static final int $$b = 213;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;
            private static int setDefaultImpl = -260894025;
            private static int[] ICustomTabsCallbackStub = {304133774, -1328472915, -1225537313, 1859159897, 1194570108, -2089502362, 712937014, 295148636, -1404980769, 693304092, 1411901384, 1991891756, 1250536631, -699854669, 1060364952, 1405429262, -76815600, -1379699239};

            /* JADX WARN: Code duplicated, block: B:10:0x0022  */
            /* JADX WARN: Code duplicated, block: B:8:0x001c  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0027). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$e(int r7, short r8, byte r9) {
                /*
                    int r9 = r9 * 4
                    int r9 = 1 - r9
                    byte[] r0 = com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda44.$$c
                    int r7 = r7 + 4
                    int r8 = 116 - r8
                    byte[] r1 = new byte[r9]
                    r2 = 0
                    if (r0 != 0) goto L12
                    r3 = r9
                    r4 = r2
                    goto L27
                L12:
                    r3 = r2
                L13:
                    int r4 = r3 + 1
                    byte r5 = (byte) r8
                    r1[r3] = r5
                    int r7 = r7 + 1
                    if (r4 != r9) goto L22
                    java.lang.String r7 = new java.lang.String
                    r7.<init>(r1, r2)
                    return r7
                L22:
                    r3 = r0[r7]
                    r6 = r3
                    r3 = r8
                    r8 = r6
                L27:
                    int r8 = -r8
                    int r8 = r8 + r3
                    r3 = r4
                    goto L13
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda44.$$e(int, short, byte):java.lang.String");
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0027  */
            /* JADX WARN: Code duplicated, block: B:8:0x001f  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002d). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static void b(short r7, byte r8, int r9, java.lang.Object[] r10) {
                /*
                    int r9 = r9 * 3
                    int r9 = 115 - r9
                    int r8 = r8 + 4
                    int r7 = r7 * 5
                    int r7 = r7 + 4
                    byte[] r0 = com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda44.$$a
                    byte[] r1 = new byte[r7]
                    r2 = 0
                    if (r0 != 0) goto L15
                    r3 = r9
                    r4 = r2
                    r9 = r8
                    goto L2d
                L15:
                    r3 = r2
                L16:
                    int r8 = r8 + 1
                    int r4 = r3 + 1
                    byte r5 = (byte) r9
                    r1[r3] = r5
                    if (r4 != r7) goto L27
                    java.lang.String r7 = new java.lang.String
                    r7.<init>(r1, r2)
                    r10[r2] = r7
                    return
                L27:
                    r3 = r0[r8]
                    r6 = r9
                    r9 = r8
                    r8 = r3
                    r3 = r6
                L2d:
                    int r8 = -r8
                    int r3 = r3 + r8
                    int r8 = r3 + (-7)
                    r3 = r4
                    r6 = r9
                    r9 = r8
                    r8 = r6
                    goto L16
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda44.b(short, byte, int, java.lang.Object[]):void");
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$background$11((DynamicScheme) obj);
            }

            /* JADX WARN: Code duplicated, block: B:32:0x0177  */
            /* JADX WARN: Code duplicated, block: B:33:0x0178  */
            private static void a(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) throws Throwable {
                int i4;
                Throwable cause;
                int i5 = 2 % 2;
                onNavigationEvent onnavigationevent = new onNavigationEvent();
                char[] cArr2 = new char[i3];
                onnavigationevent.d = 0;
                while (true) {
                    i4 = -1257606387;
                    if (onnavigationevent.d >= i3) {
                        break;
                    }
                    onnavigationevent.c = cArr[onnavigationevent.d];
                    cArr2[onnavigationevent.d] = (char) (i2 + onnavigationevent.c);
                    int i6 = onnavigationevent.d;
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr2[i6]), Integer.valueOf(setDefaultImpl)};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) (-1);
                            byte b2 = (byte) (b + 3);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(21 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) KeyEvent.getDeadChar(0, 0), (-16775441) - Color.rgb(0, 0, 0), -2069783171, false, $$e(b, b2, (byte) (b2 - 2)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr2[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        Object[] objArr3 = {onnavigationevent, onnavigationevent};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) (-1);
                            byte b4 = (byte) (b3 + 1);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(36 - TextUtils.indexOf((CharSequence) "", '0'), (char) (56277 - View.MeasureSpec.getSize(0)), 1259 - Drawable.resolveOpacity(0, 0), 711931141, false, $$e(b3, b4, b4), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                        int i7 = $11 + 125;
                        $10 = i7 % 128;
                        int i8 = i7 % 2;
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
                if (i > 0) {
                    onnavigationevent.b = i;
                    char[] cArr3 = new char[i3];
                    System.arraycopy(cArr2, 0, cArr3, 0, i3);
                    System.arraycopy(cArr3, 0, cArr2, i3 - onnavigationevent.b, onnavigationevent.b);
                    System.arraycopy(cArr3, onnavigationevent.b, cArr2, 0, i3 - onnavigationevent.b);
                    int i9 = $10 + 87;
                    $11 = i9 % 128;
                    int i10 = i9 % 2;
                }
                if (z) {
                    char[] cArr4 = new char[i3];
                    onnavigationevent.d = 0;
                    int i11 = $11 + 59;
                    $10 = i11 % 128;
                    int i12 = i11 % 2;
                    while (onnavigationevent.d < i3) {
                        cArr4[onnavigationevent.d] = cArr2[(i3 - onnavigationevent.d) - 1];
                        Object[] objArr4 = {onnavigationevent, onnavigationevent};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(i4);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) (-1);
                            byte b6 = (byte) (b5 + 1);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(37 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) ((Process.myTid() >> 22) + 56277), MotionEvent.axisFromString("") + 1260, 711931141, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                        i4 = -1257606387;
                    }
                    cArr2 = cArr4;
                }
                objArr[0] = new String(cArr2);
            }

            private static void c(int i, int[] iArr, Object[] objArr) throws Throwable {
                int i2;
                int i3 = 2 % 2;
                artificialFrame artificialframe = new artificialFrame();
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length * 2];
                int[] iArr2 = ICustomTabsCallbackStub;
                int i4 = -1780896814;
                int i5 = -1;
                int i6 = 1;
                int i7 = 0;
                if (iArr2 != null) {
                    int i8 = $10 + 23;
                    $11 = i8 % 128;
                    int i9 = i8 % 2;
                    int length = iArr2.length;
                    int[] iArr3 = new int[length];
                    int i10 = 0;
                    while (i10 < length) {
                        try {
                            Object[] objArr2 = {Integer.valueOf(iArr2[i10])};
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                            if (objAccessartificialFrame == null) {
                                byte b = (byte) i5;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - Color.green(0), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + i5), View.combineMeasuredStates(0, 0) + 1562, 180153818, false, $$e(b, (byte) (b & 7), (byte) 0), new Class[]{Integer.TYPE});
                            }
                            iArr3[i10] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                            i10++;
                            i4 = -1780896814;
                            i5 = -1;
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
                if (iArr5 != null) {
                    int i11 = $10 + 73;
                    $11 = i11 % 128;
                    int i12 = i11 % 2;
                    int length3 = iArr5.length;
                    int[] iArr6 = new int[length3];
                    int i13 = 0;
                    while (i13 < length3) {
                        int i14 = $10 + 89;
                        $11 = i14 % 128;
                        int i15 = i14 % 2;
                        try {
                            Object[] objArr3 = new Object[i6];
                            objArr3[i7] = Integer.valueOf(iArr5[i13]);
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                            if (objAccessartificialFrame2 == null) {
                                int gidForName = Process.getGidForName("") + 12;
                                char doubleTapTimeout = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                                int defaultSize = View.getDefaultSize(i7, i7) + 1562;
                                byte b2 = (byte) (-1);
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(gidForName, doubleTapTimeout, defaultSize, 180153818, false, $$e(b2, (byte) (b2 & 7), (byte) 0), new Class[]{Integer.TYPE});
                            }
                            iArr6[i13] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                            i13++;
                            iArr5 = iArr5;
                            length3 = length3;
                            i6 = 1;
                            i7 = 0;
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 == null) {
                                throw th2;
                            }
                            throw cause2;
                        }
                    }
                    i2 = i7;
                    iArr5 = iArr6;
                } else {
                    i2 = 0;
                }
                System.arraycopy(iArr5, i2, iArr4, i2, length2);
                artificialframe.e = i2;
                while (artificialframe.e < iArr.length) {
                    cArr[i2] = (char) (iArr[artificialframe.e] >> 16);
                    cArr[1] = (char) iArr[artificialframe.e];
                    cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
                    cArr[3] = (char) iArr[artificialframe.e + 1];
                    artificialframe.c = (cArr[0] << 16) + cArr[1];
                    artificialframe.b = (cArr[2] << 16) + cArr[3];
                    artificialFrame.coroutineBoundary(iArr4);
                    int i16 = 0;
                    for (int i17 = 16; i16 < i17; i17 = 16) {
                        artificialframe.c ^= iArr4[i16];
                        Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                        if (objAccessartificialFrame3 == null) {
                            byte b3 = (byte) (-1);
                            byte b4 = (byte) (-b3);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(26 - TextUtils.getCapsMode("", 0, 0), (char) View.resolveSize(0, 0), (ViewConfiguration.getTouchSlop() >> 8) + 1041, 995482881, false, $$e(b3, b4, (byte) (b4 - 1)), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                        }
                        int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                        artificialframe.c = artificialframe.b;
                        artificialframe.b = iIntValue;
                        i16++;
                    }
                    int i18 = artificialframe.c;
                    artificialframe.c = artificialframe.b;
                    artificialframe.b = i18;
                    artificialframe.b ^= iArr4[16];
                    artificialframe.c ^= iArr4[17];
                    int i19 = artificialframe.c;
                    int i20 = artificialframe.b;
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
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getFadingEdgeLength() >> 16) + 37, (char) (Gravity.getAbsoluteGravity(0, 0) + 28010), 306 - (Process.myTid() >> 22), -818175402, false, "q", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                    i2 = 0;
                }
                String str = new String(cArr2, 0, i);
                int i21 = $10 + 53;
                $11 = i21 % 128;
                if (i21 % 2 == 0) {
                    Object obj = null;
                    obj.hashCode();
                    throw null;
                }
                objArr[0] = str;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r11v126, types: [java.lang.reflect.Method] */
            /* JADX WARN: Type inference failed for: r11v170, types: [java.lang.reflect.Method] */
            /* JADX WARN: Type inference failed for: r11v204, types: [java.nio.LongBuffer] */
            /* JADX WARN: Type inference failed for: r2v237, types: [java.nio.LongBuffer[]] */
            /* JADX WARN: Type inference failed for: r2v238 */
            /* JADX WARN: Type inference failed for: r2v242 */
            /* JADX WARN: Type inference failed for: r2v243 */
            /* JADX WARN: Type inference failed for: r2v270, types: [java.lang.reflect.Method] */
            /* JADX WARN: Type inference failed for: r2v305 */
            /* JADX WARN: Type inference failed for: r2v429, types: [java.lang.reflect.Method] */
            /* JADX WARN: Type inference failed for: r2v668 */
            /* JADX WARN: Type inference failed for: r2v669 */
            /* JADX WARN: Type inference failed for: r33v10 */
            /* JADX WARN: Type inference failed for: r33v11 */
            /* JADX WARN: Type inference failed for: r33v14 */
            /* JADX WARN: Type inference failed for: r33v15 */
            /* JADX WARN: Type inference failed for: r34v19 */
            /* JADX WARN: Type inference failed for: r34v2 */
            /* JADX WARN: Type inference failed for: r34v20, types: [int] */
            /* JADX WARN: Type inference failed for: r34v21 */
            /* JADX WARN: Type inference failed for: r34v23, types: [int] */
            /* JADX WARN: Type inference failed for: r34v27 */
            /* JADX WARN: Type inference failed for: r34v28 */
            /* JADX WARN: Type inference failed for: r34v3 */
            /* JADX WARN: Type inference failed for: r34v33 */
            /* JADX WARN: Type inference failed for: r34v34 */
            /* JADX WARN: Type inference failed for: r34v35 */
            /* JADX WARN: Type inference failed for: r34v36 */
            /* JADX WARN: Type inference failed for: r34v37 */
            /* JADX WARN: Type inference failed for: r34v38 */
            /* JADX WARN: Type inference failed for: r34v39 */
            /* JADX WARN: Type inference failed for: r34v40 */
            /* JADX WARN: Type inference failed for: r34v41 */
            /* JADX WARN: Type inference failed for: r34v6 */
            /* JADX WARN: Type inference failed for: r34v7 */
            /* JADX WARN: Type inference failed for: r34v8 */
            /* JADX WARN: Type inference failed for: r36v0 */
            /* JADX WARN: Type inference failed for: r36v1, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r36v13 */
            /* JADX WARN: Type inference failed for: r36v14 */
            /* JADX WARN: Type inference failed for: r36v18 */
            /* JADX WARN: Type inference failed for: r36v19 */
            /* JADX WARN: Type inference failed for: r36v20 */
            /* JADX WARN: Type inference failed for: r36v21 */
            /* JADX WARN: Type inference failed for: r36v22 */
            /* JADX WARN: Type inference failed for: r36v23 */
            /* JADX WARN: Type inference failed for: r36v24 */
            /* JADX WARN: Type inference failed for: r36v25 */
            /* JADX WARN: Type inference failed for: r36v26 */
            /* JADX WARN: Type inference failed for: r36v27 */
            /* JADX WARN: Type inference failed for: r36v3 */
            /* JADX WARN: Type inference failed for: r36v4 */
            /* JADX WARN: Type inference failed for: r36v5, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r36v6, types: [char[]] */
            /* JADX WARN: Type inference failed for: r36v7 */
            /* JADX WARN: Type inference failed for: r36v9, types: [char[]] */
            /* JADX WARN: Type inference failed for: r3v175, types: [java.lang.Object, java.util.Date] */
            /* JADX WARN: Type inference failed for: r3v176 */
            /* JADX WARN: Type inference failed for: r3v177 */
            /* JADX WARN: Type inference failed for: r3v178, types: [java.security.KeyStore] */
            /* JADX WARN: Type inference failed for: r3v179, types: [java.security.KeyStore] */
            /* JADX WARN: Type inference failed for: r3v181 */
            /* JADX WARN: Type inference failed for: r3v185 */
            /* JADX WARN: Type inference failed for: r3v190 */
            /* JADX WARN: Type inference failed for: r3v191 */
            /* JADX WARN: Type inference failed for: r3v209 */
            /* JADX WARN: Type inference failed for: r3v230, types: [java.lang.Object, java.security.KeyStore] */
            /* JADX WARN: Type inference failed for: r3v233 */
            /* JADX WARN: Type inference failed for: r3v234 */
            /* JADX WARN: Type inference failed for: r3v374 */
            /* JADX WARN: Type inference failed for: r4v150, types: [android.security.keystore.KeyGenParameterSpec$Builder] */
            /* JADX WARN: Type inference failed for: r5v307, types: [java.nio.LongBuffer] */
            /* JADX WARN: Type inference failed for: r5v314, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r5v333 */
            /* JADX WARN: Type inference failed for: r5v334, types: [java.lang.Object, java.nio.LongBuffer] */
            /* JADX WARN: Type inference failed for: r5v747 */
            /* JADX WARN: Type inference failed for: r7v70, types: [java.lang.Object, java.nio.LongBuffer] */
            /* JADX WARN: Type inference failed for: r8v208, types: [java.lang.Object, java.nio.LongBuffer] */
            /* JADX WARN: Type inference failed for: r8v49, types: [java.lang.reflect.Method] */
            /* JADX WARN: Type inference failed for: r8v9 */
            /* JADX WARN: Type inference failed for: r9v157 */
            /* JADX WARN: Type inference failed for: r9v158 */
            /* JADX WARN: Type inference failed for: r9v159 */
            /* JADX WARN: Type inference failed for: r9v161 */
            /* JADX WARN: Type inference failed for: r9v18, types: [java.nio.LongBuffer[]] */
            /* JADX WARN: Type inference failed for: r9v22 */
            /* JADX WARN: Type inference failed for: r9v502 */
            /* JADX WARN: Type inference failed for: r9v503 */
            /* JADX WARN: Type inference failed for: r9v504 */
            /* JADX WARN: Type inference failed for: r9v505 */
            /* JADX WARN: Type inference failed for: r9v506 */
            /* JADX WARN: Type inference failed for: r9v507 */
            /* JADX WARN: Type inference failed for: r9v508 */
            /* JADX WARN: Type inference failed for: r9v509 */
            /* JADX WARN: Type inference failed for: r9v52 */
            /* JADX WARN: Type inference failed for: r9v53 */
            /* JADX WARN: Type inference failed for: r9v54 */
            /* JADX WARN: Type inference failed for: r9v77 */
            /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                java.util.NoSuchElementException
                	at java.base/java.util.TreeMap.key(Unknown Source)
                	at java.base/java.util.TreeMap.lastKey(Unknown Source)
                	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                */
            public static java.lang.Object[] accessartificialFrame(android.content.Context r47, java.lang.String[] r48, int r49, int r50, int r51) {
                /*
                    Method dump skipped, instruction units count: 16422
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda44.accessartificialFrame(android.content.Context, java.lang.String[], int, int, int):java.lang.Object[]");
            }
        }, true, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$background$11(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 6.0d : 98.0d);
    }

    public DynamicColor onBackground() {
        return new DynamicColor("on_background", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda47
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda48
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$onBackground$13((DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda49
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onBackground$14((DynamicScheme) obj);
            }
        }, null, new ContrastCurve(3.0d, 3.0d, 4.5d, 7.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onBackground$13(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 10.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onBackground$14(DynamicScheme dynamicScheme) {
        return background();
    }

    public DynamicColor surface() {
        return new DynamicColor("surface", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$surface$16((DynamicScheme) obj);
            }
        }, true, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surface$16(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 6.0d : 98.0d);
    }

    public DynamicColor surfaceDim() {
        return new DynamicColor("surface_dim", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda12
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda13
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$surfaceDim$18((DynamicScheme) obj);
            }
        }, true, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceDim$18(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 6.0d : 87.0d);
    }

    public DynamicColor surfaceBright() {
        return new DynamicColor("surface_bright", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda52
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda53
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$surfaceBright$20((DynamicScheme) obj);
            }
        }, true, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceBright$20(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 24.0d : 98.0d);
    }

    public DynamicColor surfaceContainerLowest() {
        return new DynamicColor("surface_container_lowest", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda106
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda107
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$surfaceContainerLowest$22((DynamicScheme) obj);
            }
        }, true, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceContainerLowest$22(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 4.0d : 100.0d);
    }

    public DynamicColor surfaceContainerLow() {
        return new DynamicColor("surface_container_low", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda26
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda27
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$surfaceContainerLow$24((DynamicScheme) obj);
            }
        }, true, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceContainerLow$24(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 10.0d : 96.0d);
    }

    public DynamicColor surfaceContainer() {
        return new DynamicColor("surface_container", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda134
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda135
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$surfaceContainer$26((DynamicScheme) obj);
            }
        }, true, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceContainer$26(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 12.0d : 94.0d);
    }

    public DynamicColor surfaceContainerHigh() {
        return new DynamicColor("surface_container_high", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda45
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda46
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$surfaceContainerHigh$28((DynamicScheme) obj);
            }
        }, true, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceContainerHigh$28(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 17.0d : 92.0d);
    }

    public DynamicColor surfaceContainerHighest() {
        return new DynamicColor("surface_container_highest", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda89
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda90
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$surfaceContainerHighest$30((DynamicScheme) obj);
            }
        }, true, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceContainerHighest$30(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 22.0d : 90.0d);
    }

    public DynamicColor onSurface() {
        return new DynamicColor("on_surface", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$onSurface$32((DynamicScheme) obj);
            }
        }, false, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onSurface$32(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 10.0d);
    }

    public DynamicColor surfaceVariant() {
        return new DynamicColor("surface_variant", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda81
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralVariantPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda82
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$surfaceVariant$34((DynamicScheme) obj);
            }
        }, true, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceVariant$34(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 90.0d);
    }

    public DynamicColor onSurfaceVariant() {
        return new DynamicColor("on_surface_variant", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda136
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralVariantPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda137
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$onSurfaceVariant$36((DynamicScheme) obj);
            }
        }, false, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onSurfaceVariant$36(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 30.0d);
    }

    public DynamicColor inverseSurface() {
        return new DynamicColor("inverse_surface", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda138
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda139
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$inverseSurface$38((DynamicScheme) obj);
            }
        }, false, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$inverseSurface$38(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 20.0d);
    }

    public DynamicColor inverseOnSurface() {
        return new DynamicColor("inverse_on_surface", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda116
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda117
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$inverseOnSurface$40((DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda118
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$inverseOnSurface$41((DynamicScheme) obj);
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$inverseOnSurface$40(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 20.0d : 95.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$inverseOnSurface$41(DynamicScheme dynamicScheme) {
        return inverseSurface();
    }

    public DynamicColor outline() {
        return new DynamicColor("outline", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda108
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralVariantPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda109
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$outline$43((DynamicScheme) obj);
            }
        }, false, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.5d, 3.0d, 4.5d, 7.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$outline$43(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 60.0d : 50.0d);
    }

    public DynamicColor outlineVariant() {
        return new DynamicColor("outline_variant", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda50
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralVariantPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda51
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$outlineVariant$45((DynamicScheme) obj);
            }
        }, false, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$outlineVariant$45(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 80.0d);
    }

    public DynamicColor shadow() {
        return new DynamicColor("shadow", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda87
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda88
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$shadow$47((DynamicScheme) obj);
            }
        }, false, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$shadow$47(DynamicScheme dynamicScheme) {
        return Double.valueOf(0.0d);
    }

    public DynamicColor scrim() {
        return new DynamicColor("scrim", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda154
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda155
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$scrim$49((DynamicScheme) obj);
            }
        }, false, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$scrim$49(DynamicScheme dynamicScheme) {
        return Double.valueOf(0.0d);
    }

    public DynamicColor surfaceTint() {
        return new DynamicColor("surface_tint", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda110
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).primaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda111
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$surfaceTint$51((DynamicScheme) obj);
            }
        }, true, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceTint$51(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 40.0d);
    }

    public DynamicColor primary() {
        return new DynamicColor("primary", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda151
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).primaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda152
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$primary$53((DynamicScheme) obj);
            }
        }, true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda153
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$primary$54((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$primary$53(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 100.0d : 0.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 40.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$primary$54(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(primaryContainer(), primary(), 15.0d, TonePolarity.NEARER, false);
    }

    public DynamicColor onPrimary() {
        return new DynamicColor("on_primary", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda54
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).primaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda55
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$onPrimary$56((DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda56
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onPrimary$57((DynamicScheme) obj);
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onPrimary$56(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 10.0d : 90.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 20.0d : 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimary$57(DynamicScheme dynamicScheme) {
        return primary();
    }

    public DynamicColor primaryContainer() {
        return new DynamicColor("primary_container", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda40
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).primaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda41
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$primaryContainer$59((DynamicScheme) obj);
            }
        }, true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda42
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$primaryContainer$60((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$primaryContainer$59(DynamicScheme dynamicScheme) {
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(performAlbers(dynamicScheme.sourceColorHct, dynamicScheme));
        }
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 85.0d : 25.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$primaryContainer$60(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(primaryContainer(), primary(), 15.0d, TonePolarity.NEARER, false);
    }

    public DynamicColor onPrimaryContainer() {
        return new DynamicColor("on_primary_container", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda75
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).primaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda76
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onPrimaryContainer$62((DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda77
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onPrimaryContainer$63((DynamicScheme) obj);
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Double lambda$onPrimaryContainer$62(DynamicScheme dynamicScheme) {
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.foregroundTone(primaryContainer().tone.apply(dynamicScheme).doubleValue(), 4.5d));
        }
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 0.0d : 100.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 10.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimaryContainer$63(DynamicScheme dynamicScheme) {
        return primaryContainer();
    }

    public DynamicColor inversePrimary() {
        return new DynamicColor("inverse_primary", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda57
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).primaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda58
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$inversePrimary$65((DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda59
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$inversePrimary$66((DynamicScheme) obj);
            }
        }, null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$inversePrimary$65(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 40.0d : 80.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$inversePrimary$66(DynamicScheme dynamicScheme) {
        return inverseSurface();
    }

    public DynamicColor secondary() {
        return new DynamicColor("secondary", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda103
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).secondaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda104
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$secondary$68((DynamicScheme) obj);
            }
        }, true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda105
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$secondary$69((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$secondary$68(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 40.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$secondary$69(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(secondaryContainer(), secondary(), 15.0d, TonePolarity.NEARER, false);
    }

    public DynamicColor onSecondary() {
        return new DynamicColor("on_secondary", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda100
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).secondaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda101
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$onSecondary$71((DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda102
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onSecondary$72((DynamicScheme) obj);
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onSecondary$71(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 10.0d : 100.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 20.0d : 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondary$72(DynamicScheme dynamicScheme) {
        return secondary();
    }

    public DynamicColor secondaryContainer() {
        return new DynamicColor("secondary_container", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda28
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).secondaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda29
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$secondaryContainer$74((DynamicScheme) obj);
            }
        }, true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda30
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$secondaryContainer$75((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$secondaryContainer$74(DynamicScheme dynamicScheme) {
        double d = dynamicScheme.isDark ? 30.0d : 90.0d;
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 30.0d : 85.0d);
        }
        if (!isFidelity(dynamicScheme)) {
            return Double.valueOf(d);
        }
        return Double.valueOf(performAlbers(dynamicScheme.secondaryPalette.getHct(findDesiredChromaByTone(dynamicScheme.secondaryPalette.getHue(), dynamicScheme.secondaryPalette.getChroma(), d, !dynamicScheme.isDark)), dynamicScheme));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$secondaryContainer$75(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(secondaryContainer(), secondary(), 15.0d, TonePolarity.NEARER, false);
    }

    public DynamicColor onSecondaryContainer() {
        return new DynamicColor("on_secondary_container", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda122
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).secondaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda123
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onSecondaryContainer$77((DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda124
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onSecondaryContainer$78((DynamicScheme) obj);
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Double lambda$onSecondaryContainer$77(DynamicScheme dynamicScheme) {
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.foregroundTone(secondaryContainer().tone.apply(dynamicScheme).doubleValue(), 4.5d));
        }
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 10.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondaryContainer$78(DynamicScheme dynamicScheme) {
        return secondaryContainer();
    }

    public DynamicColor tertiary() {
        return new DynamicColor("tertiary", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda160
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).tertiaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda161
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$tertiary$80((DynamicScheme) obj);
            }
        }, true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda162
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$tertiary$81((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$tertiary$80(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 90.0d : 25.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 40.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$tertiary$81(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(tertiaryContainer(), tertiary(), 15.0d, TonePolarity.NEARER, false);
    }

    public DynamicColor onTertiary() {
        return new DynamicColor("on_tertiary", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).tertiaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$onTertiary$83((DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onTertiary$84((DynamicScheme) obj);
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onTertiary$83(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 10.0d : 90.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 20.0d : 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiary$84(DynamicScheme dynamicScheme) {
        return tertiary();
    }

    public DynamicColor tertiaryContainer() {
        return new DynamicColor("tertiary_container", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda97
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).tertiaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda98
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$tertiaryContainer$86((DynamicScheme) obj);
            }
        }, true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda99
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$tertiaryContainer$87((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$tertiaryContainer$86(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 60.0d : 49.0d);
        }
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DislikeAnalyzer.fixIfDisliked(dynamicScheme.tertiaryPalette.getHct(performAlbers(dynamicScheme.tertiaryPalette.getHct(dynamicScheme.sourceColorHct.getTone()), dynamicScheme))).getTone());
        }
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$tertiaryContainer$87(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(tertiaryContainer(), tertiary(), 15.0d, TonePolarity.NEARER, false);
    }

    public DynamicColor onTertiaryContainer() {
        return new DynamicColor("on_tertiary_container", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda119
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).tertiaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda120
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onTertiaryContainer$89((DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda121
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onTertiaryContainer$90((DynamicScheme) obj);
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Double lambda$onTertiaryContainer$89(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 0.0d : 100.0d);
        }
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.foregroundTone(tertiaryContainer().tone.apply(dynamicScheme).doubleValue(), 4.5d));
        }
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 10.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiaryContainer$90(DynamicScheme dynamicScheme) {
        return tertiaryContainer();
    }

    public DynamicColor error() {
        return new DynamicColor("error", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda129
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).errorPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda130
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$error$92((DynamicScheme) obj);
            }
        }, true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new MaterialDynamicColors$$ExternalSyntheticLambda131(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$error$92(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 40.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$error$93(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(errorContainer(), error(), 15.0d, TonePolarity.NEARER, false);
    }

    public DynamicColor onError() {
        return new DynamicColor("on_error", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda70
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).errorPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda71
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$onError$95((DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda72
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onError$96((DynamicScheme) obj);
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onError$95(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 20.0d : 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onError$96(DynamicScheme dynamicScheme) {
        return error();
    }

    public DynamicColor errorContainer() {
        return new DynamicColor("error_container", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda145
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).errorPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda146
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$errorContainer$98((DynamicScheme) obj);
            }
        }, true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda147
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$errorContainer$99((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$errorContainer$98(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$errorContainer$99(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(errorContainer(), error(), 15.0d, TonePolarity.NEARER, false);
    }

    public DynamicColor onErrorContainer() {
        return new DynamicColor("on_error_container", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda140
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).errorPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda141
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$onErrorContainer$101((DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda142
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onErrorContainer$102((DynamicScheme) obj);
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onErrorContainer$101(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 10.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onErrorContainer$102(DynamicScheme dynamicScheme) {
        return errorContainer();
    }

    public DynamicColor primaryFixed() {
        return new DynamicColor("primary_fixed", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda91
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).primaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda92
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$primaryFixed$104((DynamicScheme) obj);
            }
        }, true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda93
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$primaryFixed$105((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$primaryFixed$104(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 40.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$primaryFixed$105(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(primaryFixed(), primaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public DynamicColor primaryFixedDim() {
        return new DynamicColor("primary_fixed_dim", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda94
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).primaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda95
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$primaryFixedDim$107((DynamicScheme) obj);
            }
        }, true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda96
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$primaryFixedDim$108((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$primaryFixedDim$107(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 30.0d : 80.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$primaryFixedDim$108(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(primaryFixed(), primaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public DynamicColor onPrimaryFixed() {
        return new DynamicColor("on_primary_fixed", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda125
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).primaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda126
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$onPrimaryFixed$110((DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda127
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onPrimaryFixed$111((DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda128
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onPrimaryFixed$112((DynamicScheme) obj);
            }
        }, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onPrimaryFixed$110(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 100.0d : 10.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimaryFixed$111(DynamicScheme dynamicScheme) {
        return primaryFixedDim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimaryFixed$112(DynamicScheme dynamicScheme) {
        return primaryFixed();
    }

    public DynamicColor onPrimaryFixedVariant() {
        return new DynamicColor("on_primary_fixed_variant", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda63
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).primaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda64
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$onPrimaryFixedVariant$114((DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda65
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onPrimaryFixedVariant$115((DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda66
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onPrimaryFixedVariant$116((DynamicScheme) obj);
            }
        }, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onPrimaryFixedVariant$114(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 90.0d : 30.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimaryFixedVariant$115(DynamicScheme dynamicScheme) {
        return primaryFixedDim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimaryFixedVariant$116(DynamicScheme dynamicScheme) {
        return primaryFixed();
    }

    public DynamicColor secondaryFixed() {
        return new DynamicColor("secondary_fixed", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda60
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).secondaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda61
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$secondaryFixed$118((DynamicScheme) obj);
            }
        }, true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda62
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$secondaryFixed$119((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$secondaryFixed$118(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 80.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$secondaryFixed$119(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(secondaryFixed(), secondaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public DynamicColor secondaryFixedDim() {
        return new DynamicColor("secondary_fixed_dim", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda78
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).secondaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda79
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$secondaryFixedDim$121((DynamicScheme) obj);
            }
        }, true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda80
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$secondaryFixedDim$122((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$secondaryFixedDim$121(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 70.0d : 80.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$secondaryFixedDim$122(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(secondaryFixed(), secondaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public DynamicColor onSecondaryFixed() {
        return new DynamicColor("on_secondary_fixed", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda112
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).secondaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda113
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$onSecondaryFixed$124((DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda114
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onSecondaryFixed$125((DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda115
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onSecondaryFixed$126((DynamicScheme) obj);
            }
        }, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onSecondaryFixed$124(DynamicScheme dynamicScheme) {
        return Double.valueOf(10.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondaryFixed$125(DynamicScheme dynamicScheme) {
        return secondaryFixedDim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondaryFixed$126(DynamicScheme dynamicScheme) {
        return secondaryFixed();
    }

    public DynamicColor onSecondaryFixedVariant() {
        return new DynamicColor("on_secondary_fixed_variant", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda156
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).secondaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda157
            private static long _BOUNDARY;
            private static char[] _CREATION;
            private static final byte[] $$c = {71, -70, 54, 33};
            private static final int $$d = 226;
            private static int $10 = 0;
            private static int $11 = 1;
            private static final byte[] $$a = {7, 40, -110, -80, 2, -47, -11, -53, Ascii.CR, 1, -22, -1, 3, Ascii.FF, -11, 8, 0, -17, -17, 5, 52, 53};
            private static final int $$b = 45;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;

            private static String $$e(byte b, byte b2, int i) {
                int i2 = 4 - (b2 * 2);
                int i3 = 106 - b;
                int i4 = i * 2;
                byte[] bArr = $$c;
                byte[] bArr2 = new byte[i4 + 1];
                int i5 = -1;
                if (bArr == null) {
                    i3 = i4 + i3;
                    i2++;
                }
                while (true) {
                    i5++;
                    bArr2[i5] = (byte) i3;
                    if (i5 == i4) {
                        return new String(bArr2, 0);
                    }
                    i3 += bArr[i2];
                    i2++;
                }
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0021  */
            /* JADX WARN: Code duplicated, block: B:8:0x0019  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x002b). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static void b(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
                /*
                    int r8 = 20 - r8
                    int r6 = 115 - r6
                    byte[] r0 = com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda157.$$a
                    int r1 = 4 - r7
                    byte[] r1 = new byte[r1]
                    int r7 = 3 - r7
                    r2 = 0
                    if (r0 != 0) goto L13
                    r6 = r7
                    r3 = r8
                    r4 = r2
                    goto L2b
                L13:
                    r3 = r2
                L14:
                    byte r4 = (byte) r6
                    r1[r3] = r4
                    if (r3 != r7) goto L21
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r1, r2)
                    r9[r2] = r6
                    return
                L21:
                    int r8 = r8 + 1
                    int r3 = r3 + 1
                    r4 = r0[r8]
                    r5 = r3
                    r3 = r8
                    r8 = r4
                    r4 = r5
                L2b:
                    int r8 = -r8
                    int r6 = r6 + r8
                    int r6 = r6 + (-2)
                    r8 = r3
                    r3 = r4
                    goto L14
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda157.b(byte, byte, byte, java.lang.Object[]):void");
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$onSecondaryFixedVariant$128((DynamicScheme) obj);
            }

            private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
                int i3 = 2 % 2;
                _CREATION _creation = new _CREATION();
                long[] jArr = new long[i2];
                _creation.b = 0;
                while (_creation.b < i2) {
                    int i4 = _creation.b;
                    try {
                        Object[] objArr2 = {Integer.valueOf(_CREATION[i + i4])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                        if (objAccessartificialFrame == null) {
                            int deadChar = KeyEvent.getDeadChar(0, 0) + 8;
                            char cRgb = (char) ((-16767937) - Color.rgb(0, 0, 0));
                            int i5 = 1978 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                            byte b = (byte) ($$d & 15);
                            byte b2 = (byte) (b - 2);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(deadChar, cRgb, i5, 1113883676, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                        }
                        Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i4), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = b3;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(29 - Process.getGidForName(""), (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 49362), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 684, -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                        }
                        jArr[i4] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                        Object[] objArr4 = {_creation, _creation};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 3;
                            byte b6 = (byte) (b5 - 3);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(25 - KeyEvent.keyCodeFromString(""), (char) (30068 - KeyEvent.getDeadChar(0, 0)), 816 - Color.green(0), 1897803493, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                char[] cArr = new char[i2];
                _creation.b = 0;
                while (_creation.b < i2) {
                    cArr[_creation.b] = (char) jArr[_creation.b];
                    Object[] objArr5 = {_creation, _creation};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 3;
                        byte b8 = (byte) (b7 - 3);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(25 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (30068 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 815, 1897803493, false, $$e(b7, b8, b8), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                    int i6 = $11 + 5;
                    $10 = i6 % 128;
                    int i7 = i6 % 2;
                }
                String str = new String(cArr);
                int i8 = $11 + b.i;
                $10 = i8 % 128;
                if (i8 % 2 == 0) {
                    objArr[0] = str;
                } else {
                    Object obj = null;
                    obj.hashCode();
                    throw null;
                }
            }

            static {
                char[] cArr = new char[1959];
                ByteBuffer.wrap("\u0019Ñ\u0014\u0016\u0002\u00831,/áZ%HÙGFuú`t\u009eï\u008c\u0089»\u0006©½¤7Ò®ÁZÿÀêC\u0018é\u0017}\u0005Ý3\u0085.\u001a\\¿K1y£\u0090G\u009d\u0080\u008b\u0015¸º¦wÓ³ÁOÎÐüléâ\u0017y\u0005\u001f2\u0090 +-°[5HØvAcï\u0091h\u009eè\u008cfº\u0003§\u0088Õ,\u0019Ñ\u0014\u0016\u0002\u00831,/áZ%HÙGFuú`t\u009eï\u008c\u0089»\u0006©½¤%Ò³ÁPÿÑ30>à(~\u001bÈ\u0005\u0000pÎb8m¯_\nJ\u009f´\u0002¦4\u0091è\u0083l\u008eÛøOë¹Õ:À´2\u0013=°/\u0001\u0019v\u0004ÿvKaÖSU^¢\u0019Ñ\u0014\u0017\u0002\u009219/áZ&HÑG\u0004uî``\u009eé\u008c\u008a\u0019Ñ\u0014\u0017\u0002\u009219/áZ1HßGGu°`b\u009eô\u008c\u0095»\u001e\u0019Ñ\u0014\u0001\u0002\u008219/¯Z0HÒG\u0005uÌ`T\u009eË\u008c\u0095»\u0018©\u0087¤\u0012Ò«ÁJÿÓ¨V¥\u0091³\u0000\u0080©\u009e(ëêù\u001föÎÄiÑà/h=\u0013\n\u008f\u0018\n\u0019\u008c\u0014\u001d\u0002È18/¡Z-HÂG\u0004uì`w\u009eâ\u008c\u0088»\u0001©\u008b¤2Ò\u0095ÁPÿ×êR\u0018Å\u0017j\u0005ì3\u0085.[\u0019\u008c\u0014\u001d\u0002È18/¡Z-HÂG\u0004uì`w\u009eâ\u008c\u0088»\u0001©\u008b¤2Ò\u0095ÁPÿ×êR\u0018Å\u0017j\u0005ì3\u0085.X£\u009f®O¸Ñ\u008bg\u0095ôàiò\u0095ýKÏ¼Ú5$ª6\u009b\u0001L\u0013Å\u001ezhê{\u0012EÒP\u001b¢»\u008f\u008f\u0082\b\u0094\u0092§'¹²Ì)6½;,\u0095\u0082\u0098R\u008eÌ½z£éÖtÄ\u0088ËVù¯ì(\u0012»\u0000\u00867S%Ô(h^ìM;s¬fX\u0094§\u009b8\u0089¼¿Ð¢\u0014ÐîÇnõûø\u001dî\u008f\u001d\u001e\u0003©\u0019Ñ\u0014\u0001\u0002\u009f1)/ºZ'HÛG\u0005uü`{\u009eè\u008cÕ»\u0000©\u0087¤;Ò¿Áhÿÿê\u000b\u0018ê\u0017|\u0005í3\u0086\u0019Ñ\u0014\u0001\u0002\u009f1)/ºZ'HÛG\u0005uò`{\u009eä\u008cÕ»\u0002©\u008b¤4Ò¤Á[ÿßêS\u0018Ì\u0017C\u0005ò3\u0084.\u0005\\®K|yµtU\u0019Ñ\u0014\u0016\u0002\u00831,/áZ,HÓGGuë`u\u009eó\u008c\u009f»\u001d©\u0096\u0019\u008c\u0014\u001d\u0002È18/»Z+HÚGNu°`z\u009eé\u008c\u0089»\u001a\u0092í\u009fj\u0089úºT¤ÖÑ\u0011Ã¥Ì2þ\u0097ô\u0091ùBïÔÜuÂí·-¥\u0090ª\u0003\u0098²\u008d7sµaÃV]DÖIs?ç,\r\u0019\u0090\u0014\u0017\u0002\u008b1//½Z$6\t;\u0098-M\u001e¯\u00009u¨gWhÚZxOã±-£\u0012\u0094\u008a\u0086\t\u008b¦ý)îÚÐTÅ×7j8ù*b\u001c\u0001\u0019\u0099\u0014\u0017\u0002\u00881#\u0019\u008e\u0014\u0017\u0002\u00941)/§Z1HÂG\u0004uí`k\u009eõ\u008cÔ»\f©\u0086¤xÒ®Á[ÿÐêS\u0018ý\u0017 \u0005å3\u0086.\u001f\\ðK4y§tQbË\u0091}\u008fñºz¨\u000b¦\u00adÕ\u0014Ã¿þ ì¦\u001bS\tØ\u0004{2à\u0019\u008e\u0014\u0017\u0002\u00941)/§Z1HÂG\u0004uí`k\u009eõ\u008cÔ»\f©\u0086¤xÒ®Á[ÿÐêS\u0018ý\u0017 \u0005å3\u0086.\u001f\\ðK4y§tQbË\u0091}\u008fñºz¨\u000b¦\u00adÕ\u0010Ã¿þ ì¦\u001bY\tØ¸\u0017µ\u008e£\r\u0090°\u008e>û¨é[æ\u009dÔtÁò?l-M\u001a\u0095\b\u001f\u0005ás7`Â^IKÊ¹d¶¹¤i\u0092\u0000\u008fÝý$êºØ6¤\u009c©\u0005¿\u0086\u008c;\u0092µç#õÐú\u0016ÈÿÝy#ç1Æ\u0006\u001e\u0014\u0094\u0019jo¼|IBÂWA¥ïª2¸â\u008e\u008b\u0093Vá ö!Ä·w«z2l±_\fA\u00824\u0014&ç)!\u001bÈ\u000eNðÐâñÕ)Ç£Ê]¼\u008b¯~\u0091õ\u0084vvØy\u0005kÕ]¼@a2\u0096%\u0014\u0017\u0080\u0019\u008e\u0014\u0017\u0002\u00941)/§Z1HÂG\u0004uí`k\u009eõ\u008cÔ»\f©\u0086¤xÒ®Á[ÿÐêS\u0018ý\u0017 \u0005ð3\u0099.D\\³K<y¥ÚÌ×TÁÍòfìù\u0099`\u0019Ñ\u0014\u0002\u0002\u009415/\u00adZmHÛGEuú`g\u009eê\u008c\u009f»\u001d Ø\u00ad@»Ù\u0088r\u0096ùãgñ\u0083þ\tÌº\u0019¹\u0014\u0017\u0002\u00881#/£Z-HÂGCuñ`|N\u0011C\u0086U\u0017f®x;\r¯\u001fB\u0019\u009d\u0014\u001a\u0002\u009415/£Z+HÃGG\u0019\u008c\u0014\u001d\u0002È1*/¼Z-HÒG_uý`f\u009e¨\u008c\u009e»\u000b©\u0094¤?Ò©Á[\u0005\u0016\b\u008e\u001e\u0017-¼3hFêTX\u0019\u0099\u0014\u0017\u0002\u00881?/¼Z+HÕ\u000fä\u0002j\u0014õ'B9ÁLV^¨Q\bc\u009bvW\u0088Í\u0019\u0099\u0014\u0017\u0002\u00881?/¼Z+HÕGuuæ`*\u009e°\u008c¥»X©Ö\u0019\u008c\u0014\u001d\u0002È1*/¼Z-HÒG_uý`f\u009e¨\u008c\u0097»\u0001©\u0086¤3Ò¦ýXðÃæX\u0019\u009b\u0014\u001f\u0002\u009316/¯Z6HÙGX\u0019¿\u0014\u0002\u0002\u00961z/\u009cZ7HØG^u÷`\u007f\u009eã\u008cÚ»\b©\u008d¤$ÒêÁ}ÿÚêT\u0018õ\u0017c\u0005ç\u008d?\u0080\u009c\u0096\u0002¥¨»!Î«ÜRÓ\u008aáMôÖ\nM\u0018Z/\u008c=\u00170¿F&UÊk\u0012~À\u008cu\u0083ü\u0091\"§\u000eºÒÈh\u0093\u0010\u009e³\u0088-»\u0087¥\u000eÐ\u0084Â}Í¥ÿbêù\u0014b\u0006u1£#8.\u0090X\tKåu=`ï\u0092Z\u009dÓ\u008f\r¹!¤ýÖGÁ¢ó_þ¡W\u0096Z\u0007LÒ\u007f(aµ\u0014*\u0006È\tG;å.zÐù\u0019\u0099\u0014\u001d\u0002\u008a1>/¨Z+HÅGB\u0007«\n3\u001cª/\u00011ÕDW@\u0089M\u0016[\u008dh<v£\u00032\u0019\u008c\u0014\u001d\u0002È1*/¼Z-HÒG_uý`f\u009e¨\u008c\u0098»\u001c©\u0083¤8Ò®\u0019\u008c\u0014\u001d\u0002È11/«Z0HØGOuò`<\u009e÷\u008c\u009f»\u0003©\u0097\u0019Ï\u0019\u008c\u0014\u001d\u0002È1)/«Z!HÃGXuû\u0019Î\u0019\u008c\u0014\u001d\u0002È18/»Z+HÚGNu°`b\u009eô\u008c\u0095»\n©\u0097¤5Ò¾\u0019\u0098\u0014\u0007\u0002\u008a16/\u0091Z:H\u008eG\u001c\u0019\u008c\u0014\u001d\u0002È18/»Z+HÚGNu°`t\u009eï\u008c\u0094»\t©\u0087¤$ÒºÁLÿÛêH\u0018î\u0019\u0099\u0014\u0017\u0002\u00881?/¼Z+HÕG\u0005uí`v\u009eí\u008cÕ»\t©\u0087¤8Ò¯ÁLÿÛêE\u000eÞ\u0003P\u0015Ï&x8ûMl_\u0092P2b¡wm\u0089÷\u009b\u0092¬Z¾Á³zÅÒÖ\u0001èÍýW\u000fò\u0000.\u0012 $ß9HKë\\|nâc\"u\u0091\u0086]\u0098ç\u0019\u0099\u0014\u0017\u0002\u00881?/¼Z+HÕG\u0005uù`}\u009eé\u008c\u009d»\u0002©\u0087¤\tÒ¹ÁZÿÙê\t\u0018ý\u0017k\u0005ì3\u0093.\u0018\\·K1T=Y³O,|\u009bb\u0018\u0017\u008f\u0005q\n¡8L-ÔÓMÁ&öòäpé\u0082\u009fA\u008cì²t§íUFZ\u0092H\u0010~\"\u0019\u0099\u0014\u001d\u0002\u00891=/¢Z'H\u0099GYuú`y\u009eÙ\u008c\u009d»\u001e©\u008a¤9Ò¤Á[ÿíê^\u0018¢\u00178\u0005\u00ad3\u0091.\u000f\\°K7y´tSbÍ\u0091}\u008fîº2¨H\u0019\u008c\u0014\u001d\u0002È18/¡Z-HÂGFuñ`s\u009eâ\u008c\u009f»\u001c\u0083\u0019\u008e\u0088\u0098]«\u00adµ4À¸ÒWÝÖïfúæ\u0004t\u0016\n!Õ3\u0015>¶H6[ÇeCp\u009d\u0082i\u008dò\u009fy©\u0004´\u009aÆ9Ñ·ã!îÆøU\u000bÃv\u000e{\u00adm3^\u0099@\u00105\u009a'c(¶\u001aW\u000f\u009bñ\u0001\u0019\u008c\u0014\u001d\u0002È18/»Z+HÚGNu°`v\u009eï\u008c\u0089»\u001e©\u008e¤7Ò³Á\u0010ÿÛêB\u0016O\u001bÒ\rP>ë &j¬g'q´B\u0015\\Û)\n;û4r\u0006\u008b\u0013XíØÿ¬È Úô×\u001d¡\u0083²j\u008cù\u0099n¯G¢ß´C\u0087ç\u0099(ìâþ\tñÌÃ;Ö»(':\\\rÍ\u001fO\u0012çdq\u0019\u008f\u0014\u0017\u0002\u008b1//àZ1HÐG\u0004uø`s\u009eí\u008c\u009f»1©\u0081¤7Ò§Á[ÿÀêG\u0019\u008f\u0014\u0017\u0002\u008b1//àZ1HÐG\u0004uò`q\u009eâ\u008c¥»\n©\u0087¤8Ò¹ÁWÿÆê_@yMè[=hÄv^\u0003Å\u0011-\u001eº,\u00079ÉÇ\u0012ÕaâÿðeýÌ\u008bV\u0098¯¦i³¢A\nN\u0096\\\u0002jg\u0019\u008c\u0014\u001d\u0002È18/¡Z-HÂG\u0004uï`w\u009eë\u008c\u008f»@©\u0083¤ Ò®ÁaÿÜêG\u0018÷\u0017k\u0019\u008c\u0014\u001d\u0002È15/ªZ/H\u0098GHuë`{\u009eê\u008c\u009e»@©\u0084¤?Ò¤ÁYÿ×êT\u0018ê\u0017|\u0005ë3\u0098.\u001e&j+û=.\u000eÌ\u0010ZeËw4x¹J\u001b_\u0080¡N³~\u0084ý\u0096m\u009bÜíHþöÀ2Õ©'\u0012(\u008f:\u0001\fb\u0011ücJtÝFNK¨Õ±Ø Îõý\u0014ã\u008a\u0096\f\u0084ÿ\u008br¹Î¬\u0001RÙ@²w:e³h\u000f\u001eÙ\re3æ&uÔÀÛVÉÍÿ»â%\u0090\u008a\u0087\u0001µ\u008f·øºi¬¼\u009f]\u0081ÃôEæ¶é;Û\u0087Î90\u0097\"ö\u0015n\u0007¸\n@|Ëo#QªD6¶À¹\u001c«\u009f\u009dì\u0080yòÏåT×ÂÚ<Ì³?8!\u0096á\u0099ì\búÝÉ9×¾¢9°Ç¿P\u008dù\u0098)fñt\u009aC\u0012Q\u009b\\'*ñ9M\u0007Î\u0012]àèï~ýåË\u0093Ö\r¤¢³)\u0081§#».*8ÿ\u000b\u001b\u0015\u009c`\u001brå}rOÛZz¤Õ¶¡\u00812\u0093¸\u009eOè\u009fû|ÅìÐ}\"É-\u0017?Ó\t¨\u00143f\u008eq\u0000C\u0083N}Xë«|µÏ\u0080IR)\u0019Ñ\u0014\u0016\u0002\u00831,/áZ3HÓGGuë`M\u009eö\u008c\u0093»\u001e©\u0087\u0019Ñ\u0014\u0016\u0002\u00831,/áZ1HÙGIuõ`w\u009eò\u008cÕ»\f©\u0083¤%Ò¯Á\\ÿÓêH\u0018þ\u0017Q\u0005å3\u0093.\u0004\\§K6\u0019Ñ\u0014\u0016\u0002\u00831,/áZ1HÙGIuõ`w\u009eò\u008cÕ»\t©\u0087¤8Ò³ÁZ¡C¬\u0084º\u0011\u0089¾\u0097sâ£ðKÿÛÍgØå&`4G\u0003\u008d\u0011\u0015\u001c©j-yÈ\u0019Ñ\u0014\u0001\u0002\u009f1)/áZ3HÓGGuë`M\u009eò\u008c\u0088»\u000f©\u0081¤3\u0004\u0003\tÓ\u001fM,û2hGõU\tZ×h }©\u00836\u0091\u0007¦Ð´Y¹æÏ{Ü³â\r÷\u0095\u0005$\n°\u0018?.G3çAhVådvi\u009d\u007f\u001b\u008c¯\u00925§½µÁ»UÈ\u009aÞ{ãó\u008d\u001c\u0080Û\u0096N¥á»,ÎíÜ\bÓ\u0093á\fô¸\n;\u0018D\u001c\u0003\u0011Ä\u0007Q4þ*3_òM\u0017B\u008cp\u0013e´\u009b=\u0089E¾Ù\u0019Ñ\u0014\u0016\u0002\u00831,/áZ1HÙGIuõ`w\u009eò\u008cÕ»\f©\u0091¤\"Ò¬ÁQÿÞêB\u0018ÿ\u0017|\u0005æ\u0019Ñ\u0014\u0001\u0002\u009f1)/ºZ'HÛG\u0005uò`{\u009eä\u008cÕ»\u0002©\u008b¤4Ò¨ÁMÿÆê@\u0018õ\u0017b\u0005æ3\u0093.\u0018\\\u0081K8y¨tSb\u0080\u0091Q\u008fù\"\u0013/Ô9A\nî\u0014#aâs\u0007|\u009cN=[³¥'·]=Û0\u001c&\u0089\u0015&\u000bë~*lÏcTQóDaºþ¨\u009f\u0019Ñ\u0014\u0016\u0002\u00831,/áZ HÅG^uó`w\u009eá\u008c\u0094~\u0093sTeÁVnH£=b/\u0087 \u001c\u0012³\u0007\"ù\u00adëÝ\u0019Ñ\u0014\u0016\u0002\u00831,/áZ HÅG^uè`\u007f\u009eõ\u008c\u009d\u0019Ñ\u0014\u0016\u0002\u00831,/áZ HÅG^uî`u\u009eç\u008c\u0093»\u001e©\u0081æ8ëÿýjÎÅÐ\b¥É·,¸·\u008a(\u009f\u0092a\u0002svòäÿ#é²Ú\u001bÄ\u009a±X£ç¬p\u009eÜ\u008bIußg P:B³O\u00109Ð*%\u0014ÿ\u0001qó\u0080üYîÄØ·Å4\u0019Ñ\u0014\u001f\u0002\u00881./áZ5HßGDuú`}\u009eñ\u008c\u0089»A© ¤%Ò¾ÁmÿÚêG\u0018è\u0017k\u0005æ3°.\u0005\\²K6y£tH\u0019Ñ\u0014\u0002\u0002\u009415/\u00adZmHßGEuî`}\u009eô\u008c\u008e»\u001d\u009b¼\u0096f\u0080ò³\b\u00ad\u0086\u0019Ñ\u0014\u0002\u0002\u009415/\u00adZmHÅGOuò`t\u009e©\u008c\u0097»\u000f©\u0092¤%\u0084N\u0089×\u009fP¬á²uÇúÕ\u0002ÚÓè.ýª\u0003=\u0011I&ß4\\9òOu\\Çb\u0016w\u009e\u0019\u0092\u0014\u001b\u0002\u00841\u001d/\u0082Z\u0007HåGuuü`a\u009eò\u008cÔ»\u001d©\u008d\u0019Ñ\u0014\u0017\u0002\u009219/áZ/HÓGNu÷`s\u009eÙ\u008c\u0099»\u0001©\u0086¤3Ò©ÁMÿ\u009cê^\u0018÷\u0017b\u0019\u009c\u0014\u001e\u0002\u00931?/½Z6H×GIuõ`a\u0019Ñ\u0014\u0017\u0002\u009219/áZ/HÙG_uð`f\u009eõ\u001d\u0003\u0010Ä\u0006U5ü+}^¿L\u0000C\u0097q;d®\u009a8\u0088G¿Ý\u00adT ÷Ö7ÅÂû\u0004î\u0084\u001cg\u0013½\u0001 7T*ËX\"Oø}yp\u0084?32à$v\u0017×\tO|\u008fn7a¸S\tF\u0099¸\nª~\u009dã\u0019¹\u0014\u001d\u0002\u008a1>/¨Z+HÅGB°[½\u009c«\r\u0098¤\u0086%óçáQîÉÜgÉû7#%\u0000\u0012\u0096\u0000\u0007\rº{)hØV]Cß±?¾ç¬}\u009a\u000e\u0087Ïõdâ÷Ð/ÝßËI8\u0086&q\u0013é\u0001\u0097\u000f\n|\u0083j&W\u00adE:²È \u000e\u00adù\u009b}\u0088áö\u0085ä\rÑ\u0085ß9".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
                _CREATION = cArr;
                _BOUNDARY = -1892080865957899150L;
            }

            /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                java.util.NoSuchElementException
                	at java.base/java.util.TreeMap.key(Unknown Source)
                	at java.base/java.util.TreeMap.lastKey(Unknown Source)
                	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                */
            public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r75, int r76, int r77, int r78) {
                /*
                    Method dump skipped, instruction units count: 15062
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda157.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda158
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onSecondaryFixedVariant$129((DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda159
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onSecondaryFixedVariant$130((DynamicScheme) obj);
            }
        }, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onSecondaryFixedVariant$128(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 25.0d : 30.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondaryFixedVariant$129(DynamicScheme dynamicScheme) {
        return secondaryFixedDim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondaryFixedVariant$130(DynamicScheme dynamicScheme) {
        return secondaryFixed();
    }

    public DynamicColor tertiaryFixed() {
        return new DynamicColor("tertiary_fixed", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda148
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).tertiaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda149
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$tertiaryFixed$132((DynamicScheme) obj);
            }
        }, true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda150
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$tertiaryFixed$133((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$tertiaryFixed$132(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 40.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$tertiaryFixed$133(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(tertiaryFixed(), tertiaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public DynamicColor tertiaryFixedDim() {
        return new DynamicColor("tertiary_fixed_dim", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda67
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).tertiaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda68
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$tertiaryFixedDim$135((DynamicScheme) obj);
            }
        }, true, new MaterialDynamicColors$$ExternalSyntheticLambda9(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda69
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$tertiaryFixedDim$136((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$tertiaryFixedDim$135(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 30.0d : 80.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair lambda$tertiaryFixedDim$136(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(tertiaryFixed(), tertiaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public DynamicColor onTertiaryFixed() {
        return new DynamicColor("on_tertiary_fixed", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda31
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).tertiaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda32
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$onTertiaryFixed$138((DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda33
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onTertiaryFixed$139((DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda34
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onTertiaryFixed$140((DynamicScheme) obj);
            }
        }, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onTertiaryFixed$138(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 100.0d : 10.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiaryFixed$139(DynamicScheme dynamicScheme) {
        return tertiaryFixedDim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiaryFixed$140(DynamicScheme dynamicScheme) {
        return tertiaryFixed();
    }

    public DynamicColor onTertiaryFixedVariant() {
        return new DynamicColor("on_tertiary_fixed_variant", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda20
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).tertiaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda21
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$onTertiaryFixedVariant$142((DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda22
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onTertiaryFixedVariant$143((DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda23
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$onTertiaryFixedVariant$144((DynamicScheme) obj);
            }
        }, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onTertiaryFixedVariant$142(DynamicScheme dynamicScheme) {
        return Double.valueOf(isMonochrome(dynamicScheme) ? 90.0d : 30.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiaryFixedVariant$143(DynamicScheme dynamicScheme) {
        return tertiaryFixedDim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiaryFixedVariant$144(DynamicScheme dynamicScheme) {
        return tertiaryFixed();
    }

    public DynamicColor controlActivated() {
        return DynamicColor.fromPalette("control_activated", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda16
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).primaryPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda17
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$controlActivated$146((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$controlActivated$146(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 90.0d);
    }

    public DynamicColor controlNormal() {
        return DynamicColor.fromPalette("control_normal", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda14
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralVariantPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda15
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$controlNormal$148((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$controlNormal$148(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 30.0d);
    }

    public DynamicColor controlHighlight() {
        return new DynamicColor("control_highlight", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda37
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda38
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$controlHighlight$150((DynamicScheme) obj);
            }
        }, false, null, null, null, null, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda39
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$controlHighlight$151((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$controlHighlight$150(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 100.0d : 0.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$controlHighlight$151(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 0.2d : 0.12d);
    }

    public DynamicColor textPrimaryInverse() {
        return DynamicColor.fromPalette("text_primary_inverse", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda132
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda133
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$textPrimaryInverse$153((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$textPrimaryInverse$153(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 10.0d : 90.0d);
    }

    public DynamicColor textSecondaryAndTertiaryInverse() {
        return DynamicColor.fromPalette("text_secondary_and_tertiary_inverse", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda143
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralVariantPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda144
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$textSecondaryAndTertiaryInverse$155((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$textSecondaryAndTertiaryInverse$155(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 80.0d);
    }

    public DynamicColor textPrimaryInverseDisableOnly() {
        return DynamicColor.fromPalette("text_primary_inverse_disable_only", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda73
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda74
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$textPrimaryInverseDisableOnly$157((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$textPrimaryInverseDisableOnly$157(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 10.0d : 90.0d);
    }

    public DynamicColor textSecondaryAndTertiaryInverseDisabled() {
        return DynamicColor.fromPalette("text_secondary_and_tertiary_inverse_disabled", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$textSecondaryAndTertiaryInverseDisabled$159((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$textSecondaryAndTertiaryInverseDisabled$159(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 10.0d : 90.0d);
    }

    public DynamicColor textHintInverse() {
        return DynamicColor.fromPalette("text_hint_inverse", new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda85
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).neutralPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.MaterialDynamicColors$$ExternalSyntheticLambda86
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.lambda$textHintInverse$161((DynamicScheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$textHintInverse$161(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 10.0d : 90.0d);
    }

    private static ViewingConditions viewingConditionsForAlbers(DynamicScheme dynamicScheme) {
        return ViewingConditions.defaultWithBackgroundLstar(dynamicScheme.isDark ? 30.0d : 80.0d);
    }

    private static boolean isFidelity(DynamicScheme dynamicScheme) {
        Variant variant = dynamicScheme.variant;
        return variant == Variant.FIDELITY || variant == Variant.CONTENT;
    }

    private static boolean isMonochrome(DynamicScheme dynamicScheme) {
        return dynamicScheme.variant == Variant.MONOCHROME;
    }

    static double findDesiredChromaByTone(double d, double d2, double d3, boolean z) {
        Hct hctFrom = Hct.from(d, d2, d3);
        if (hctFrom.getChroma() >= d2) {
            return d3;
        }
        Hct hct = hctFrom;
        double chroma = hctFrom.getChroma();
        double d4 = d3;
        while (hct.getChroma() < d2) {
            double d5 = d4 + (z ? -1.0d : 1.0d);
            Hct hctFrom2 = Hct.from(d, d2, d5);
            if (chroma > hctFrom2.getChroma() || Math.abs(hctFrom2.getChroma() - d2) < 0.4d) {
                return d5;
            }
            if (Math.abs(hctFrom2.getChroma() - d2) < Math.abs(hct.getChroma() - d2)) {
                hct = hctFrom2;
            }
            chroma = Math.max(chroma, hctFrom2.getChroma());
            d4 = d5;
        }
        return d4;
    }

    static double performAlbers(Hct hct, DynamicScheme dynamicScheme) {
        Hct hctInViewingConditions = hct.inViewingConditions(viewingConditionsForAlbers(dynamicScheme));
        if (DynamicColor.tonePrefersLightForeground(hct.getTone()) && !DynamicColor.toneAllowsLightForeground(hctInViewingConditions.getTone())) {
            return DynamicColor.enableLightForeground(hct.getTone());
        }
        return DynamicColor.enableLightForeground(hctInViewingConditions.getTone());
    }
}
