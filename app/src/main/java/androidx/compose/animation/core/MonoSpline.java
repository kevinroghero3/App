package androidx.compose.animation.core;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class MonoSpline {
    public static final int $stable = 8;
    private final boolean isExtrapolate = true;
    private final float[] slopeTemp;
    private final float[][] tangents;
    private final float[] timePoints;
    private final float[][] values;

    private final float diff(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f2 * f2;
        float f8 = 6;
        float f9 = f8 * f2;
        float f10 = 3 * f;
        return ((((((((((-6) * f7) * f4) + (f4 * f9)) + ((f8 * f7) * f3)) - (f9 * f3)) + ((f10 * f6) * f7)) + ((f10 * f5) * f7)) - (((2 * f) * f6) * f2)) - (((4 * f) * f5) * f2)) + (f * f5);
    }

    private final float interpolate(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f2 * f2;
        float f8 = f7 * f2;
        float f9 = 3 * f7;
        float f10 = 2;
        float f11 = f6 * f;
        float f12 = f * f5;
        return (((((((((((-2) * f8) * f4) + (f4 * f9)) + ((f10 * f8) * f3)) - (f9 * f3)) + f3) + (f11 * f8)) + (f8 * f12)) - (f11 * f7)) - (((f10 * f) * f5) * f7)) + (f12 * f2);
    }

    public MonoSpline(@NotNull float[] fArr, @NotNull float[][] fArr2, float f) {
        int i;
        int length = fArr.length;
        int i2 = 0;
        int length2 = fArr2[0].length;
        this.slopeTemp = new float[length2];
        int i3 = length - 1;
        float[][] fArrMakeFloatArray = makeFloatArray(i3, length2);
        float[][] fArrMakeFloatArray2 = makeFloatArray(length, length2);
        for (int i4 = 0; i4 < length2; i4++) {
            int i5 = 0;
            while (i5 < i3) {
                int i6 = i5 + 1;
                float f2 = fArr[i6];
                float f3 = fArr[i5];
                float[] fArr3 = fArrMakeFloatArray[i5];
                float f4 = (fArr2[i6][i4] - fArr2[i5][i4]) / (f2 - f3);
                fArr3[i4] = f4;
                if (i5 == 0) {
                    fArrMakeFloatArray2[i5][i4] = f4;
                } else {
                    fArrMakeFloatArray2[i5][i4] = (fArrMakeFloatArray[i5 - 1][i4] + f4) * 0.5f;
                }
                i5 = i6;
            }
            fArrMakeFloatArray2[i3][i4] = fArrMakeFloatArray[length - 2][i4];
        }
        if (!Float.isNaN(f)) {
            for (int i7 = 0; i7 < length2; i7++) {
                float[] fArr4 = fArrMakeFloatArray[length - 2];
                float f5 = fArr4[i7];
                float[] fArr5 = fArrMakeFloatArray[0];
                float f6 = (f5 * (1 - f)) + (fArr5[i7] * f);
                fArr5[i7] = f6;
                fArr4[i7] = f6;
                fArrMakeFloatArray2[i3][i7] = f6;
                fArrMakeFloatArray2[0][i7] = f6;
            }
        }
        int i8 = 0;
        while (i8 < i3) {
            int i9 = i2;
            while (i9 < length2) {
                float f7 = fArrMakeFloatArray[i8][i9];
                if (f7 == 0.0f) {
                    fArrMakeFloatArray2[i8][i9] = 0.0f;
                    fArrMakeFloatArray2[i8 + 1][i9] = 0.0f;
                    i = length2;
                } else {
                    float f8 = fArrMakeFloatArray2[i8][i9] / f7;
                    int i10 = i8 + 1;
                    float f9 = fArrMakeFloatArray2[i10][i9] / f7;
                    i = length2;
                    float fHypot = (float) Math.hypot(f8, f9);
                    if (fHypot > 9.0d) {
                        float f10 = 3.0f / fHypot;
                        float[] fArr6 = fArrMakeFloatArray2[i8];
                        float[] fArr7 = fArrMakeFloatArray[i8];
                        fArr6[i9] = f8 * f10 * fArr7[i9];
                        fArrMakeFloatArray2[i10][i9] = f10 * f9 * fArr7[i9];
                    }
                }
                i9++;
                length2 = i;
            }
            i8++;
            i2 = 0;
        }
        this.timePoints = fArr;
        this.values = fArr2;
        this.tangents = fArrMakeFloatArray2;
    }

    private final float[][] makeFloatArray(int i, int i2) {
        float[][] fArr = new float[i][];
        for (int i3 = 0; i3 < i; i3++) {
            fArr[i3] = new float[i2];
        }
        return fArr;
    }

    public final float getPos(float f, int i) {
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int i2 = 0;
        if (this.isExtrapolate) {
            float f2 = fArr[0];
            if (f <= f2) {
                return this.values[0][i] + ((f - f2) * getSlope(f2, i));
            }
            int i3 = length - 1;
            float f3 = fArr[i3];
            if (f >= f3) {
                return this.values[i3][i] + ((f - f3) * getSlope(f3, i));
            }
        } else {
            if (f <= fArr[0]) {
                return this.values[0][i];
            }
            int i4 = length - 1;
            if (f >= fArr[i4]) {
                return this.values[i4][i];
            }
        }
        while (i2 < length - 1) {
            float[] fArr2 = this.timePoints;
            float f4 = fArr2[i2];
            if (f == f4) {
                return this.values[i2][i];
            }
            int i5 = i2 + 1;
            float f5 = fArr2[i5];
            if (f < f5) {
                float f6 = f5 - f4;
                float f7 = (f - f4) / f6;
                float[][] fArr3 = this.values;
                float f8 = fArr3[i2][i];
                float f9 = fArr3[i5][i];
                float[][] fArr4 = this.tangents;
                return interpolate(f6, f7, f8, f9, fArr4[i2][i], fArr4[i5][i]);
            }
            i2 = i5;
        }
        return 0.0f;
    }

    public static /* synthetic */ void getPos$default(MonoSpline monoSpline, float f, AnimationVector animationVector, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        monoSpline.getPos(f, animationVector, i);
    }

    public final void getPos(float f, @NotNull AnimationVector animationVector, int i) {
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int i2 = 0;
        int length2 = this.values[0].length;
        if (this.isExtrapolate) {
            float f2 = fArr[0];
            if (f <= f2) {
                getSlope(f2, this.slopeTemp);
                for (int i3 = 0; i3 < length2; i3++) {
                    animationVector.set$animation_core_release(i3, this.values[0][i3] + ((f - this.timePoints[0]) * this.slopeTemp[i3]));
                }
                return;
            }
            int i4 = length - 1;
            float f3 = fArr[i4];
            if (f >= f3) {
                getSlope(f3, this.slopeTemp);
                while (i2 < length2) {
                    animationVector.set$animation_core_release(i2, this.values[i4][i2] + ((f - this.timePoints[i4]) * this.slopeTemp[i2]));
                    i2++;
                }
                return;
            }
        } else {
            if (f <= fArr[0]) {
                for (int i5 = 0; i5 < length2; i5++) {
                    animationVector.set$animation_core_release(i5, this.values[0][i5]);
                }
                return;
            }
            int i6 = length - 1;
            if (f >= fArr[i6]) {
                while (i2 < length2) {
                    animationVector.set$animation_core_release(i2, this.values[i6][i2]);
                    i2++;
                }
                return;
            }
        }
        int i7 = i;
        while (i7 < length - 1) {
            if (f == this.timePoints[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    animationVector.set$animation_core_release(i8, this.values[i7][i8]);
                }
            }
            float[] fArr2 = this.timePoints;
            int i9 = i7 + 1;
            float f4 = fArr2[i9];
            if (f < f4) {
                float f5 = fArr2[i7];
                float f6 = f4 - f5;
                float f7 = (f - f5) / f6;
                for (int i10 = 0; i10 < length2; i10++) {
                    float[][] fArr3 = this.values;
                    float f8 = fArr3[i7][i10];
                    float f9 = fArr3[i9][i10];
                    float[][] fArr4 = this.tangents;
                    animationVector.set$animation_core_release(i10, interpolate(f6, f7, f8, f9, fArr4[i7][i10], fArr4[i9][i10]));
                }
                return;
            }
            i7 = i9;
        }
    }

    public final void getSlope(float f, @NotNull float[] fArr) {
        float f2;
        float[] fArr2 = this.timePoints;
        int length = fArr2.length;
        int length2 = this.values[0].length;
        float f3 = fArr2[0];
        if (f <= f3) {
            f2 = f3;
        } else {
            f2 = fArr2[length - 1];
            if (f < f2) {
                f2 = f;
            }
        }
        int i = 0;
        while (i < length - 1) {
            float[] fArr3 = this.timePoints;
            int i2 = i + 1;
            float f4 = fArr3[i2];
            if (f2 <= f4) {
                float f5 = fArr3[i];
                float f6 = f4 - f5;
                float f7 = (f2 - f5) / f6;
                for (int i3 = 0; i3 < length2; i3++) {
                    float[][] fArr4 = this.values;
                    float f8 = fArr4[i][i3];
                    float f9 = fArr4[i2][i3];
                    float[][] fArr5 = this.tangents;
                    fArr[i3] = diff(f6, f7, f8, f9, fArr5[i][i3], fArr5[i2][i3]) / f6;
                }
                return;
            }
            i = i2;
        }
    }

    public static /* synthetic */ void getSlope$default(MonoSpline monoSpline, float f, AnimationVector animationVector, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        monoSpline.getSlope(f, animationVector, i);
    }

    public final void getSlope(float f, @NotNull AnimationVector animationVector, int i) {
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int length2 = this.values[0].length;
        if (f <= fArr[0]) {
            for (int i2 = 0; i2 < length2; i2++) {
                animationVector.set$animation_core_release(i2, this.tangents[0][i2]);
            }
            return;
        }
        int i3 = length - 1;
        if (f >= fArr[i3]) {
            for (int i4 = 0; i4 < length2; i4++) {
                animationVector.set$animation_core_release(i4, this.tangents[i3][i4]);
            }
            return;
        }
        int i5 = i;
        while (i5 < i3) {
            float[] fArr2 = this.timePoints;
            int i6 = i5 + 1;
            float f2 = fArr2[i6];
            if (f <= f2) {
                float f3 = fArr2[i5];
                float f4 = f2 - f3;
                float f5 = (f - f3) / f4;
                for (int i7 = 0; i7 < length2; i7++) {
                    float[][] fArr3 = this.values;
                    float f6 = fArr3[i5][i7];
                    float f7 = fArr3[i6][i7];
                    float[][] fArr4 = this.tangents;
                    animationVector.set$animation_core_release(i7, diff(f4, f5, f6, f7, fArr4[i5][i7], fArr4[i6][i7]) / f4);
                }
                return;
            }
            i5 = i6;
        }
    }

    private final float getSlope(float f, int i) {
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int i2 = 0;
        float f2 = fArr[0];
        if (f < f2) {
            f = f2;
        } else {
            float f3 = fArr[length - 1];
            if (f >= f3) {
                f = f3;
            }
        }
        while (i2 < length - 1) {
            float[] fArr2 = this.timePoints;
            int i3 = i2 + 1;
            float f4 = fArr2[i3];
            if (f <= f4) {
                float f5 = fArr2[i2];
                float f6 = f4 - f5;
                float f7 = (f - f5) / f6;
                float[][] fArr3 = this.values;
                float f8 = fArr3[i2][i];
                float f9 = fArr3[i3][i];
                float[][] fArr4 = this.tangents;
                return diff(f6, f7, f8, f9, fArr4[i2][i], fArr4[i3][i]) / f6;
            }
            i2 = i3;
        }
        return 0.0f;
    }
}
