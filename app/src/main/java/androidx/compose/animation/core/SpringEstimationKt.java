package androidx.compose.animation.core;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class SpringEstimationKt {
    private static final long MAX_LONG_MILLIS = 9223372036854L;

    public static final long estimateAnimationDurationMillis(float f, float f2, float f3, float f4, float f5) {
        return f2 == 0.0f ? MAX_LONG_MILLIS : estimateAnimationDurationMillis(f, f2, f3, f4, f5);
    }

    public static final long estimateAnimationDurationMillis(double d, double d2, double d3, double d4, double d5) {
        double dSqrt = 2.0d * d2 * Math.sqrt(d);
        double d6 = (dSqrt * dSqrt) - (4.0d * d);
        double d7 = -dSqrt;
        ComplexDouble complexDoubleComplexSqrt = ComplexDoubleKt.complexSqrt(d6);
        complexDoubleComplexSqrt._real += d7;
        complexDoubleComplexSqrt._real *= 0.5d;
        complexDoubleComplexSqrt._imaginary *= 0.5d;
        ComplexDouble complexDoubleComplexSqrt2 = ComplexDoubleKt.complexSqrt(d6);
        double d8 = -1;
        complexDoubleComplexSqrt2._real *= d8;
        complexDoubleComplexSqrt2._imaginary *= d8;
        complexDoubleComplexSqrt2._real += d7;
        complexDoubleComplexSqrt2._real *= 0.5d;
        complexDoubleComplexSqrt2._imaginary *= 0.5d;
        return estimateDurationInternal(complexDoubleComplexSqrt, complexDoubleComplexSqrt2, d2, d3, d4, d5);
    }

    public static final long estimateAnimationDurationMillis(double d, double d2, double d3, double d4, double d5, double d6) {
        double dSqrt = d2 / (Math.sqrt(d * d3) * 2.0d);
        double d7 = (d2 * d2) - ((4.0d * d3) * d);
        double d8 = 1.0d / (2.0d * d3);
        double d9 = -d2;
        ComplexDouble complexDoubleComplexSqrt = ComplexDoubleKt.complexSqrt(d7);
        complexDoubleComplexSqrt._real += d9;
        complexDoubleComplexSqrt._real *= d8;
        complexDoubleComplexSqrt._imaginary *= d8;
        ComplexDouble complexDoubleComplexSqrt2 = ComplexDoubleKt.complexSqrt(d7);
        double d10 = -1;
        complexDoubleComplexSqrt2._real *= d10;
        complexDoubleComplexSqrt2._imaginary *= d10;
        complexDoubleComplexSqrt2._real += d9;
        complexDoubleComplexSqrt2._real *= d8;
        complexDoubleComplexSqrt2._imaginary *= d8;
        return estimateDurationInternal(complexDoubleComplexSqrt, complexDoubleComplexSqrt2, dSqrt, d4, d5, d6);
    }

    private static final double estimateUnderDamped(ComplexDouble complexDouble, double d, double d2, double d3) {
        double real = complexDouble.getReal();
        double imaginary = (d2 - (real * d)) / complexDouble.getImaginary();
        return Math.log(d3 / Math.sqrt((d * d) + (imaginary * imaginary))) / real;
    }

    private static final double estimateCriticallyDamped(ComplexDouble complexDouble, double d, double d2, double d3) {
        double d4 = d3;
        double real = complexDouble.getReal();
        double d5 = real * d;
        double d6 = d2 - d5;
        double dLog = Math.log(Math.abs(d4 / d)) / real;
        double dLog2 = Math.log(Math.abs(d4 / d6));
        double dLog3 = dLog2;
        for (int i = 0; i < 6; i++) {
            dLog3 = dLog2 - Math.log(Math.abs(dLog3 / real));
        }
        double d7 = dLog3 / real;
        if (Double.isInfinite(dLog) || Double.isNaN(dLog)) {
            dLog = d7;
        } else if (!Double.isInfinite(d7) && !Double.isNaN(d7)) {
            dLog = Math.max(dLog, d7);
        }
        double d8 = (-(d5 + d6)) / (real * d6);
        double d9 = real * d8;
        double dExp = Math.exp(d9);
        double dExp2 = Math.exp(d9);
        if (Double.isNaN(d8) || d8 <= 0.0d) {
            d4 = -d4;
        } else if (d8 <= 0.0d || (-((dExp * d) + (d8 * d6 * dExp2))) >= d4) {
            dLog = (-(2.0d / real)) - (d / d6);
        } else {
            if (d6 < 0.0d && d > 0.0d) {
                dLog = 0.0d;
            }
            d4 = -d4;
        }
        double dAbs = Double.MAX_VALUE;
        int i2 = 0;
        while (dAbs > 0.001d && i2 < 100) {
            i2++;
            double d10 = real * dLog;
            double d11 = real;
            double dExp3 = dLog - ((((d + (d6 * dLog)) * Math.exp(d10)) + d4) / ((((((double) 1) + d10) * d6) + d5) * Math.exp(d10)));
            dAbs = Math.abs(dLog - dExp3);
            dLog = dExp3;
            real = d11;
        }
        return dLog;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00b9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c9  */
    private static final double estimateOverDamped(ComplexDouble complexDouble, ComplexDouble complexDouble2, double d, double d2, double d3) {
        double d4;
        double d5;
        double dLog;
        double d6;
        double d7;
        int i;
        double d8 = d3;
        double real = complexDouble.getReal();
        double real2 = complexDouble2.getReal();
        double d9 = real - real2;
        double d10 = ((real * d) - d2) / d9;
        double d11 = d - d10;
        double dLog2 = Math.log(Math.abs(d8 / d11)) / real;
        double dLog3 = Math.log(Math.abs(d8 / d10)) / real2;
        if (Double.isInfinite(dLog2) || Double.isNaN(dLog2)) {
            d4 = dLog3;
        } else {
            if (!Double.isInfinite(dLog3) && !Double.isNaN(dLog3)) {
                dLog2 = Math.max(dLog2, dLog3);
            }
            d4 = dLog2;
        }
        double d12 = d11 * real;
        double dLog4 = Math.log(d12 / ((-d10) * real2)) / (real2 - real);
        if (!Double.isNaN(dLog4) && dLog4 > 0.0d) {
            if (dLog4 > 0.0d) {
                d5 = d10;
                if ((-estimateOverDamped$xInflection(d11, real, dLog4, d10, real2)) < d8) {
                    if (d5 > 0.0d && d11 < 0.0d) {
                        d4 = 0.0d;
                    }
                }
                d6 = d5 * real2;
                if (Math.abs((Math.exp(real * dLog) * d12) + (Math.exp(real2 * dLog) * d6)) < 1.0E-4d) {
                    return dLog;
                }
                d7 = Double.MAX_VALUE;
                i = 0;
                while (d7 > 0.001d && i < 100) {
                    i++;
                    double d13 = real * dLog;
                    double d14 = real2 * dLog;
                    double dExp = dLog - ((((Math.exp(d13) * d11) + (Math.exp(d14) * d5)) + d8) / ((Math.exp(d13) * d12) + (Math.exp(d14) * d6)));
                    double dAbs = Math.abs(dLog - dExp);
                    dLog = dExp;
                    d7 = dAbs;
                }
                return dLog;
            }
            d5 = d10;
            dLog = Math.log((-((d5 * real2) * real2)) / (d12 * real)) / d9;
            d6 = d5 * real2;
            if (Math.abs((Math.exp(real * dLog) * d12) + (Math.exp(real2 * dLog) * d6)) < 1.0E-4d) {
                return dLog;
            }
            d7 = Double.MAX_VALUE;
            i = 0;
            while (d7 > 0.001d) {
                i++;
                double d15 = real * dLog;
                double d16 = real2 * dLog;
                double dExp2 = dLog - ((((Math.exp(d15) * d11) + (Math.exp(d16) * d5)) + d8) / ((Math.exp(d15) * d12) + (Math.exp(d16) * d6)));
                double dAbs2 = Math.abs(dLog - dExp2);
                dLog = dExp2;
                d7 = dAbs2;
            }
            return dLog;
        }
        d5 = d10;
        d8 = -d8;
        dLog = d4;
        d6 = d5 * real2;
        if (Math.abs((Math.exp(real * dLog) * d12) + (Math.exp(real2 * dLog) * d6)) < 1.0E-4d) {
            return dLog;
        }
        d7 = Double.MAX_VALUE;
        i = 0;
        while (d7 > 0.001d) {
            i++;
            double d17 = real * dLog;
            double d18 = real2 * dLog;
            double dExp3 = dLog - ((((Math.exp(d17) * d11) + (Math.exp(d18) * d5)) + d8) / ((Math.exp(d17) * d12) + (Math.exp(d18) * d6)));
            double dAbs3 = Math.abs(dLog - dExp3);
            dLog = dExp3;
            d7 = dAbs3;
        }
        return dLog;
    }

    private static final double estimateOverDamped$xInflection(double d, double d2, double d3, double d4, double d5) {
        return (d * Math.exp(d2 * d3)) + (d4 * Math.exp(d5 * d3));
    }

    private static final long estimateDurationInternal(ComplexDouble complexDouble, ComplexDouble complexDouble2, double d, double d2, double d3, double d4) {
        double dEstimateCriticallyDamped;
        double d5 = d2;
        if (d3 == 0.0d && d5 == 0.0d) {
            return 0L;
        }
        if (d3 < 0.0d) {
            d5 = -d5;
        }
        double dAbs = Math.abs(d3);
        if (d > 1.0d) {
            dEstimateCriticallyDamped = estimateOverDamped(complexDouble, complexDouble2, dAbs, d5, d4);
        } else if (d < 1.0d) {
            dEstimateCriticallyDamped = estimateUnderDamped(complexDouble, dAbs, d5, d4);
        } else {
            dEstimateCriticallyDamped = estimateCriticallyDamped(complexDouble, dAbs, d5, d4);
        }
        return (long) (dEstimateCriticallyDamped * 1000.0d);
    }

    private static final double iterateNewtonsMethod(double d, Function1<? super Double, Double> function1, Function1<? super Double, Double> function2) {
        return d - (function1.invoke(Double.valueOf(d)).doubleValue() / function2.invoke(Double.valueOf(d)).doubleValue());
    }

    private static final boolean isNotFinite(double d) {
        return !((Double.isInfinite(d) || Double.isNaN(d)) ? false : true);
    }
}
