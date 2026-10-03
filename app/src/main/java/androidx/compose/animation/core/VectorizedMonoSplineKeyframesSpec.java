package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import androidx.compose.animation.core.AnimationVector;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class VectorizedMonoSplineKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 8;
    private final int delayMillis;
    private final int durationMillis;
    private final IntObjectMap<Pair<V, Easing>> keyframes;
    private V lastInitialValue;
    private V lastTargetValue;
    private MonoSpline monoSpline;
    private final float periodicBias;
    private float[] times;
    private final IntList timestamps;
    private V valueVector;
    private float[][] values;
    private V velocityVector;

    public VectorizedMonoSplineKeyframesSpec(@NotNull IntList intList, @NotNull IntObjectMap<Pair<V, Easing>> intObjectMap, int i, int i2, float f) {
        this.timestamps = intList;
        this.keyframes = intObjectMap;
        this.durationMillis = i;
        this.delayMillis = i2;
        this.periodicBias = f;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDurationMillis() {
        return this.durationMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDelayMillis() {
        return this.delayMillis;
    }

    private final void init(V v, V v2, V v3) {
        float[] fArr;
        float[] fArr2;
        if (this.valueVector == null) {
            this.valueVector = (V) AnimationVectorsKt.newInstance(v);
            this.velocityVector = (V) AnimationVectorsKt.newInstance(v3);
            int size = this.timestamps.getSize();
            float[] fArr3 = new float[size];
            for (int i = 0; i < size; i++) {
                fArr3[i] = this.timestamps.get(i) / 1000;
            }
            this.times = fArr3;
        }
        if (this.monoSpline != null && Intrinsics.areEqual(this.lastInitialValue, v) && Intrinsics.areEqual(this.lastTargetValue, v2)) {
            return;
        }
        boolean zAreEqual = Intrinsics.areEqual(this.lastInitialValue, v);
        boolean zAreEqual2 = Intrinsics.areEqual(this.lastTargetValue, v2);
        this.lastInitialValue = v;
        this.lastTargetValue = v2;
        int size$animation_core_release = v.getSize$animation_core_release();
        float[][] fArr4 = null;
        if (this.values == null) {
            int size2 = this.timestamps.getSize();
            float[][] fArr5 = new float[size2][];
            for (int i2 = 0; i2 < size2; i2++) {
                int i3 = this.timestamps.get(i2);
                if (i3 == 0) {
                    if (!this.keyframes.contains(i3)) {
                        fArr2 = new float[size$animation_core_release];
                        for (int i4 = 0; i4 < size$animation_core_release; i4++) {
                            fArr2[i4] = v.get$animation_core_release(i4);
                        }
                    } else {
                        fArr = new float[size$animation_core_release];
                        Pair<V, Easing> pair = this.keyframes.get(i3);
                        Intrinsics.checkNotNull(pair);
                        V first = pair.getFirst();
                        for (int i5 = 0; i5 < size$animation_core_release; i5++) {
                            fArr[i5] = first.get$animation_core_release(i5);
                        }
                        fArr2 = fArr;
                    }
                } else {
                    if (i3 == getDurationMillis()) {
                        if (!this.keyframes.contains(i3)) {
                            fArr2 = new float[size$animation_core_release];
                            for (int i6 = 0; i6 < size$animation_core_release; i6++) {
                                fArr2[i6] = v2.get$animation_core_release(i6);
                            }
                        } else {
                            fArr = new float[size$animation_core_release];
                            Pair<V, Easing> pair2 = this.keyframes.get(i3);
                            Intrinsics.checkNotNull(pair2);
                            V first2 = pair2.getFirst();
                            for (int i7 = 0; i7 < size$animation_core_release; i7++) {
                                fArr[i7] = first2.get$animation_core_release(i7);
                            }
                        }
                    } else {
                        fArr = new float[size$animation_core_release];
                        Pair<V, Easing> pair3 = this.keyframes.get(i3);
                        Intrinsics.checkNotNull(pair3);
                        V first3 = pair3.getFirst();
                        for (int i8 = 0; i8 < size$animation_core_release; i8++) {
                            fArr[i8] = first3.get$animation_core_release(i8);
                        }
                    }
                    fArr2 = fArr;
                }
                fArr5[i2] = fArr2;
            }
            this.values = fArr5;
        } else {
            if (!zAreEqual && !this.keyframes.contains(0)) {
                float[][] fArr6 = this.values;
                if (fArr6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("values");
                    fArr6 = null;
                }
                int iBinarySearch$default = IntListExtensionKt.binarySearch$default(this.timestamps, 0, 0, 0, 6, null);
                float[] fArr7 = new float[size$animation_core_release];
                for (int i9 = 0; i9 < size$animation_core_release; i9++) {
                    fArr7[i9] = v.get$animation_core_release(i9);
                }
                fArr6[iBinarySearch$default] = fArr7;
            }
            if (!zAreEqual2 && !this.keyframes.contains(getDurationMillis())) {
                float[][] fArr8 = this.values;
                if (fArr8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("values");
                    fArr8 = null;
                }
                int iBinarySearch$default2 = IntListExtensionKt.binarySearch$default(this.timestamps, getDurationMillis(), 0, 0, 6, null);
                float[] fArr9 = new float[size$animation_core_release];
                for (int i10 = 0; i10 < size$animation_core_release; i10++) {
                    fArr9[i10] = v2.get$animation_core_release(i10);
                }
                fArr8[iBinarySearch$default2] = fArr9;
            }
        }
        float[] fArr10 = this.times;
        if (fArr10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("times");
            fArr10 = null;
        }
        float[][] fArr11 = this.values;
        if (fArr11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("values");
        } else {
            fArr4 = fArr11;
        }
        this.monoSpline = new MonoSpline(fArr10, fArr4, this.periodicBias);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long j, @NotNull V v, @NotNull V v2, @NotNull V v3) {
        int iClampPlayTime = (int) VectorizedAnimationSpecKt.clampPlayTime(this, j / AnimationKt.MillisToNanos);
        if (this.keyframes.containsKey(iClampPlayTime)) {
            Pair<V, Easing> pair = this.keyframes.get(iClampPlayTime);
            Intrinsics.checkNotNull(pair);
            return pair.getFirst();
        }
        if (iClampPlayTime >= getDurationMillis()) {
            return v2;
        }
        if (iClampPlayTime <= 0) {
            return v;
        }
        init(v, v2, v3);
        int iFindEntryForTimeMillis = findEntryForTimeMillis(iClampPlayTime);
        MonoSpline monoSpline = this.monoSpline;
        if (monoSpline == null) {
            Intrinsics.throwUninitializedPropertyAccessException("monoSpline");
            monoSpline = null;
        }
        float easedTimeFromIndex = getEasedTimeFromIndex(iFindEntryForTimeMillis, iClampPlayTime);
        V v4 = this.valueVector;
        if (v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            v4 = null;
        }
        monoSpline.getPos(easedTimeFromIndex, v4, iFindEntryForTimeMillis);
        V v5 = this.valueVector;
        if (v5 != null) {
            return v5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long j, @NotNull V v, @NotNull V v2, @NotNull V v3) {
        int iClampPlayTime = (int) VectorizedAnimationSpecKt.clampPlayTime(this, j / AnimationKt.MillisToNanos);
        if (iClampPlayTime < 0) {
            return v3;
        }
        init(v, v2, v3);
        int iFindEntryForTimeMillis = findEntryForTimeMillis(iClampPlayTime);
        MonoSpline monoSpline = this.monoSpline;
        if (monoSpline == null) {
            Intrinsics.throwUninitializedPropertyAccessException("monoSpline");
            monoSpline = null;
        }
        float easedTimeFromIndex = getEasedTimeFromIndex(iFindEntryForTimeMillis, iClampPlayTime);
        V v4 = this.velocityVector;
        if (v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            v4 = null;
        }
        monoSpline.getSlope(easedTimeFromIndex, v4, iFindEntryForTimeMillis);
        V v5 = this.velocityVector;
        if (v5 != null) {
            return v5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }

    private final Easing getEasing(int i) {
        Easing second;
        Pair<V, Easing> pair = this.keyframes.get(this.timestamps.get(i));
        return (pair == null || (second = pair.getSecond()) == null) ? EasingKt.getLinearEasing() : second;
    }

    private final float getEasedTimeFromIndex(int i, int i2) {
        float f;
        IntList intList = this.timestamps;
        if (i >= intList._size - 1) {
            f = i2;
        } else {
            int i3 = intList.get(i);
            int i4 = this.timestamps.get(i + 1);
            if (i2 != i3) {
                float f2 = i4 - i3;
                return ((f2 * getEasing(i).transform((i2 - i3) / f2)) + i3) / 1000;
            }
            f = i3;
        }
        return f / 1000;
    }

    private final int findEntryForTimeMillis(int i) {
        int iBinarySearch$default = IntListExtensionKt.binarySearch$default(this.timestamps, i, 0, 0, 6, null);
        return iBinarySearch$default < -1 ? -(iBinarySearch$default + 2) : iBinarySearch$default;
    }
}
