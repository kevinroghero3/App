package androidx.compose.animation.core;

import kotlin.Pair;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ComplexDoubleKt {
    public static final Pair<ComplexDouble, ComplexDouble> complexQuadraticFormula(double d, double d2, double d3) {
        double d4 = (d2 * d2) - ((4.0d * d) * d3);
        double d5 = 1.0d / (d * 2.0d);
        double d6 = -d2;
        ComplexDouble complexDoubleComplexSqrt = complexSqrt(d4);
        complexDoubleComplexSqrt._real += d6;
        complexDoubleComplexSqrt._real *= d5;
        complexDoubleComplexSqrt._imaginary *= d5;
        ComplexDouble complexDoubleComplexSqrt2 = complexSqrt(d4);
        double d7 = -1;
        complexDoubleComplexSqrt2._real *= d7;
        complexDoubleComplexSqrt2._imaginary *= d7;
        complexDoubleComplexSqrt2._real += d6;
        complexDoubleComplexSqrt2._real *= d5;
        complexDoubleComplexSqrt2._imaginary *= d5;
        return TuplesKt.to(complexDoubleComplexSqrt, complexDoubleComplexSqrt2);
    }

    public static final ComplexDouble complexSqrt(double d) {
        if (d < 0.0d) {
            return new ComplexDouble(0.0d, Math.sqrt(Math.abs(d)));
        }
        return new ComplexDouble(Math.sqrt(d), 0.0d);
    }

    public static final ComplexDouble plus(double d, @NotNull ComplexDouble complexDouble) {
        complexDouble._real += d;
        return complexDouble;
    }

    public static final ComplexDouble minus(double d, @NotNull ComplexDouble complexDouble) {
        double d2 = -1;
        complexDouble._real *= d2;
        complexDouble._imaginary *= d2;
        complexDouble._real += d;
        return complexDouble;
    }

    public static final ComplexDouble times(double d, @NotNull ComplexDouble complexDouble) {
        complexDouble._real *= d;
        complexDouble._imaginary *= d;
        return complexDouble;
    }
}
