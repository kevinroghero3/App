package androidx.compose.ui.graphics;

import ch.qos.logback.core.CoreConstants;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@JvmInline
public final class ColorMatrix {
    private final float[] values;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ColorMatrix m1224boximpl(float[] fArr) {
        return new ColorMatrix(fArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float[] m1225constructorimpl(@NotNull float[] fArr) {
        return fArr;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1230equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof ColorMatrix) && Intrinsics.areEqual(fArr, ((ColorMatrix) obj).m1245unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1231equalsimpl0(float[] fArr, float[] fArr2) {
        return Intrinsics.areEqual(fArr, fArr2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1233hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1244toStringimpl(float[] fArr) {
        return "ColorMatrix(values=" + Arrays.toString(fArr) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public boolean equals(Object obj) {
        return m1230equalsimpl(this.values, obj);
    }

    public int hashCode() {
        return m1233hashCodeimpl(this.values);
    }

    public String toString() {
        return m1244toStringimpl(this.values);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float[] m1245unboximpl() {
        return this.values;
    }

    private /* synthetic */ ColorMatrix(float[] fArr) {
        this.values = fArr;
    }

    public final float[] getValues() {
        return this.values;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ float[] m1226constructorimpl$default(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        }
        return m1225constructorimpl(fArr);
    }

    /* JADX INFO: renamed from: get-impl, reason: not valid java name */
    public static final float m1232getimpl(float[] fArr, int i, int i2) {
        return fArr[(i * 5) + i2];
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m1236setimpl(float[] fArr, int i, int i2, float f) {
        fArr[(i * 5) + i2] = f;
    }

    /* JADX INFO: renamed from: reset-impl, reason: not valid java name */
    public static final void m1234resetimpl(float[] fArr) {
        ArraysKt___ArraysJvmKt.fill$default(fArr, 0.0f, 0, 0, 6, (Object) null);
        fArr[0] = 1.0f;
        fArr[12] = 1.0f;
        fArr[6] = 1.0f;
        fArr[18] = 1.0f;
    }

    /* JADX INFO: renamed from: set-jHG-Opc, reason: not valid java name */
    public static final void m1237setjHGOpc(float[] fArr, @NotNull float[] fArr2) {
        ArraysKt___ArraysJvmKt.copyInto$default(fArr2, fArr, 0, 0, 0, 14, (Object) null);
    }

    /* JADX INFO: renamed from: rotateInternal-impl, reason: not valid java name */
    private static final void m1235rotateInternalimpl(float[] fArr, float f, Function2<? super Float, ? super Float, Unit> function2) {
        m1234resetimpl(fArr);
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        function2.invoke(Float.valueOf((float) Math.cos(d)), Float.valueOf((float) Math.sin(d)));
    }

    /* JADX INFO: renamed from: timesAssign-jHG-Opc, reason: not valid java name */
    public static final void m1243timesAssignjHGOpc(float[] fArr, @NotNull float[] fArr2) {
        float fM1229dotMe4OoYI = m1229dotMe4OoYI(fArr, fArr, 0, fArr2, 0);
        float fM1229dotMe4OoYI2 = m1229dotMe4OoYI(fArr, fArr, 0, fArr2, 1);
        float fM1229dotMe4OoYI3 = m1229dotMe4OoYI(fArr, fArr, 0, fArr2, 2);
        float fM1229dotMe4OoYI4 = m1229dotMe4OoYI(fArr, fArr, 0, fArr2, 3);
        float f = fArr[0];
        float f2 = fArr2[4];
        float f3 = fArr[1];
        float f4 = fArr2[9];
        float f5 = fArr[2];
        float f6 = fArr2[14];
        float f7 = fArr[3];
        float f8 = fArr2[19];
        float f9 = fArr[4];
        float fM1229dotMe4OoYI5 = m1229dotMe4OoYI(fArr, fArr, 1, fArr2, 0);
        float fM1229dotMe4OoYI6 = m1229dotMe4OoYI(fArr, fArr, 1, fArr2, 1);
        float fM1229dotMe4OoYI7 = m1229dotMe4OoYI(fArr, fArr, 1, fArr2, 2);
        float fM1229dotMe4OoYI8 = m1229dotMe4OoYI(fArr, fArr, 1, fArr2, 3);
        float f10 = fArr[5];
        float f11 = fArr2[4];
        float f12 = fArr[6];
        float f13 = fArr2[9];
        float f14 = fArr[7];
        float f15 = fArr2[14];
        float f16 = fArr[8];
        float f17 = fArr2[19];
        float f18 = fArr[9];
        float fM1229dotMe4OoYI9 = m1229dotMe4OoYI(fArr, fArr, 2, fArr2, 0);
        float fM1229dotMe4OoYI10 = m1229dotMe4OoYI(fArr, fArr, 2, fArr2, 1);
        float fM1229dotMe4OoYI11 = m1229dotMe4OoYI(fArr, fArr, 2, fArr2, 2);
        float fM1229dotMe4OoYI12 = m1229dotMe4OoYI(fArr, fArr, 2, fArr2, 3);
        float f19 = fArr[10];
        float f20 = fArr2[4];
        float f21 = fArr[11];
        float f22 = fArr2[9];
        float f23 = fArr[12];
        float f24 = fArr2[14];
        float f25 = fArr[13];
        float f26 = fArr2[19];
        float f27 = fArr[14];
        float fM1229dotMe4OoYI13 = m1229dotMe4OoYI(fArr, fArr, 3, fArr2, 0);
        float fM1229dotMe4OoYI14 = m1229dotMe4OoYI(fArr, fArr, 3, fArr2, 1);
        float fM1229dotMe4OoYI15 = m1229dotMe4OoYI(fArr, fArr, 3, fArr2, 2);
        float fM1229dotMe4OoYI16 = m1229dotMe4OoYI(fArr, fArr, 3, fArr2, 3);
        float f28 = fArr[15];
        float f29 = fArr2[4];
        float f30 = fArr[16];
        float f31 = fArr2[9];
        float f32 = fArr[17];
        float f33 = fArr2[14];
        float f34 = fArr[18];
        float f35 = fArr2[19];
        float f36 = fArr[19];
        fArr[0] = fM1229dotMe4OoYI;
        fArr[1] = fM1229dotMe4OoYI2;
        fArr[2] = fM1229dotMe4OoYI3;
        fArr[3] = fM1229dotMe4OoYI4;
        fArr[4] = (f * f2) + (f3 * f4) + (f5 * f6) + (f7 * f8) + f9;
        fArr[5] = fM1229dotMe4OoYI5;
        fArr[6] = fM1229dotMe4OoYI6;
        fArr[7] = fM1229dotMe4OoYI7;
        fArr[8] = fM1229dotMe4OoYI8;
        fArr[9] = (f10 * f11) + (f12 * f13) + (f14 * f15) + (f16 * f17) + f18;
        fArr[10] = fM1229dotMe4OoYI9;
        fArr[11] = fM1229dotMe4OoYI10;
        fArr[12] = fM1229dotMe4OoYI11;
        fArr[13] = fM1229dotMe4OoYI12;
        fArr[14] = (f19 * f20) + (f21 * f22) + (f23 * f24) + (f25 * f26) + f27;
        fArr[15] = fM1229dotMe4OoYI13;
        fArr[16] = fM1229dotMe4OoYI14;
        fArr[17] = fM1229dotMe4OoYI15;
        fArr[18] = fM1229dotMe4OoYI16;
        fArr[19] = (f28 * f29) + (f30 * f31) + (f32 * f33) + (f34 * f35) + f36;
    }

    /* JADX INFO: renamed from: setToSaturation-impl, reason: not valid java name */
    public static final void m1241setToSaturationimpl(float[] fArr, float f) {
        m1234resetimpl(fArr);
        float f2 = 1 - f;
        float f3 = 0.213f * f2;
        float f4 = 0.715f * f2;
        float f5 = f2 * 0.072f;
        fArr[0] = f3 + f;
        fArr[1] = f4;
        fArr[2] = f5;
        fArr[5] = f3;
        fArr[6] = f4 + f;
        fArr[7] = f5;
        fArr[10] = f3;
        fArr[11] = f4;
        fArr[12] = f5 + f;
    }

    /* JADX INFO: renamed from: setToScale-impl, reason: not valid java name */
    public static final void m1242setToScaleimpl(float[] fArr, float f, float f2, float f3, float f4) {
        m1234resetimpl(fArr);
        fArr[0] = f;
        fArr[6] = f2;
        fArr[12] = f3;
        fArr[18] = f4;
    }

    /* JADX INFO: renamed from: convertRgbToYuv-impl, reason: not valid java name */
    public static final void m1227convertRgbToYuvimpl(float[] fArr) {
        m1234resetimpl(fArr);
        fArr[0] = 0.299f;
        fArr[1] = 0.587f;
        fArr[2] = 0.114f;
        fArr[5] = -0.16874f;
        fArr[6] = -0.33126f;
        fArr[7] = 0.5f;
        fArr[10] = 0.5f;
        fArr[11] = -0.41869f;
        fArr[12] = -0.08131f;
    }

    /* JADX INFO: renamed from: convertYuvToRgb-impl, reason: not valid java name */
    public static final void m1228convertYuvToRgbimpl(float[] fArr) {
        m1234resetimpl(fArr);
        fArr[2] = 1.402f;
        fArr[5] = 1.0f;
        fArr[6] = -0.34414f;
        fArr[7] = -0.71414f;
        fArr[10] = 1.0f;
        fArr[11] = 1.772f;
        fArr[12] = 0.0f;
    }

    /* JADX INFO: renamed from: dot-Me4OoYI, reason: not valid java name */
    private static final float m1229dotMe4OoYI(float[] fArr, float[] fArr2, int i, float[] fArr3, int i2) {
        int i3 = i * 5;
        return (fArr2[i3] * fArr3[i2]) + (fArr2[i3 + 1] * fArr3[i2 + 5]) + (fArr2[i3 + 2] * fArr3[i2 + 10]) + (fArr2[i3 + 3] * fArr3[i2 + 15]);
    }

    /* JADX INFO: renamed from: setToRotateRed-impl, reason: not valid java name */
    public static final void m1240setToRotateRedimpl(float[] fArr, float f) {
        m1234resetimpl(fArr);
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        fArr[12] = fCos;
        fArr[6] = fCos;
        fArr[7] = fSin;
        fArr[11] = -fSin;
    }

    /* JADX INFO: renamed from: setToRotateGreen-impl, reason: not valid java name */
    public static final void m1239setToRotateGreenimpl(float[] fArr, float f) {
        m1234resetimpl(fArr);
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        fArr[12] = fCos;
        fArr[0] = fCos;
        fArr[2] = -fSin;
        fArr[10] = fSin;
    }

    /* JADX INFO: renamed from: setToRotateBlue-impl, reason: not valid java name */
    public static final void m1238setToRotateBlueimpl(float[] fArr, float f) {
        m1234resetimpl(fArr);
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        fArr[6] = fCos;
        fArr[0] = fCos;
        fArr[1] = fSin;
        fArr[5] = -fSin;
    }
}
