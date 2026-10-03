package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.animation.core.AnimationVector;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class VectorizedKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 8;
    private ArcSpline arcSpline;
    private final Easing defaultEasing;
    private final int delayMillis;
    private final int durationMillis;
    private final int initialArcMode;
    private final IntObjectMap<VectorizedKeyframeSpecElementInfo<V>> keyframes;
    private V lastInitialValue;
    private V lastTargetValue;
    private int[] modes;
    private float[] posArray;
    private float[] slopeArray;
    private float[] times;
    private final IntList timestamps;
    private V valueVector;
    private V velocityVector;

    public /* synthetic */ VectorizedKeyframesSpec(IntList intList, IntObjectMap intObjectMap, int i, int i2, Easing easing, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(intList, intObjectMap, i, i2, easing, i3);
    }

    private VectorizedKeyframesSpec(IntList intList, IntObjectMap<VectorizedKeyframeSpecElementInfo<V>> intObjectMap, int i, int i2, Easing easing, int i3) {
        this.timestamps = intList;
        this.keyframes = intObjectMap;
        this.durationMillis = i;
        this.delayMillis = i2;
        this.defaultEasing = easing;
        this.initialArcMode = i3;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDurationMillis() {
        return this.durationMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDelayMillis() {
        return this.delayMillis;
    }

    public /* synthetic */ VectorizedKeyframesSpec(Map map, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, i, (i3 & 4) != 0 ? 0 : i2);
    }

    public VectorizedKeyframesSpec(@NotNull Map<Integer, ? extends Pair<? extends V, ? extends Easing>> map, int i, int i2) {
        MutableIntList mutableIntList = new MutableIntList(map.size() + 2);
        Iterator<Map.Entry<Integer, ? extends Pair<? extends V, ? extends Easing>>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            mutableIntList.add(it2.next().getKey().intValue());
        }
        if (!map.containsKey(0)) {
            mutableIntList.add(0, 0);
        }
        if (!map.containsKey(Integer.valueOf(i))) {
            mutableIntList.add(i);
        }
        mutableIntList.sort();
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        for (Map.Entry<Integer, ? extends Pair<? extends V, ? extends Easing>> entry : map.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            Pair<? extends V, ? extends Easing> value = entry.getValue();
            mutableIntObjectMap.set(iIntValue, new VectorizedKeyframeSpecElementInfo(value.getFirst(), value.getSecond(), ArcMode.Companion.m314getArcLinear9TMq4(), null));
        }
        this(mutableIntList, mutableIntObjectMap, i, i2, EasingKt.getLinearEasing(), ArcMode.Companion.m314getArcLinear9TMq4(), null);
    }

    private final void init(V v, V v2, V v3) {
        float[] fArr;
        float[] fArr2;
        boolean z = this.arcSpline != null;
        if (this.valueVector == null) {
            this.valueVector = (V) AnimationVectorsKt.newInstance(v);
            this.velocityVector = (V) AnimationVectorsKt.newInstance(v3);
            int size = this.timestamps.getSize();
            float[] fArr3 = new float[size];
            for (int i = 0; i < size; i++) {
                fArr3[i] = this.timestamps.get(i) / 1000;
            }
            this.times = fArr3;
            int size2 = this.timestamps.getSize();
            int[] iArr = new int[size2];
            for (int i2 = 0; i2 < size2; i2++) {
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(this.timestamps.get(i2));
                int iM368getArcMode9TMq4 = vectorizedKeyframeSpecElementInfo != null ? vectorizedKeyframeSpecElementInfo.m368getArcMode9TMq4() : this.initialArcMode;
                if (!ArcMode.m308equalsimpl0(iM368getArcMode9TMq4, ArcMode.Companion.m314getArcLinear9TMq4())) {
                    z = true;
                }
                iArr[i2] = iM368getArcMode9TMq4;
            }
            this.modes = iArr;
        }
        if (z) {
            float[] fArr4 = null;
            if (this.arcSpline != null) {
                V v4 = this.lastInitialValue;
                if (v4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lastInitialValue");
                    v4 = null;
                }
                if (Intrinsics.areEqual(v4, v)) {
                    V v5 = this.lastTargetValue;
                    if (v5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("lastTargetValue");
                        v5 = null;
                    }
                    if (Intrinsics.areEqual(v5, v2)) {
                        return;
                    }
                }
            }
            this.lastInitialValue = v;
            this.lastTargetValue = v2;
            int size$animation_core_release = (v.getSize$animation_core_release() % 2) + v.getSize$animation_core_release();
            this.posArray = new float[size$animation_core_release];
            this.slopeArray = new float[size$animation_core_release];
            int size3 = this.timestamps.getSize();
            float[][] fArr5 = new float[size3][];
            for (int i3 = 0; i3 < size3; i3++) {
                int i4 = this.timestamps.get(i3);
                if (i4 == 0) {
                    if (!this.keyframes.contains(i4)) {
                        fArr2 = new float[size$animation_core_release];
                        for (int i5 = 0; i5 < size$animation_core_release; i5++) {
                            fArr2[i5] = v.get$animation_core_release(i5);
                        }
                    } else {
                        fArr = new float[size$animation_core_release];
                        VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo2 = this.keyframes.get(i4);
                        Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo2);
                        AnimationVector vectorValue = vectorizedKeyframeSpecElementInfo2.getVectorValue();
                        for (int i6 = 0; i6 < size$animation_core_release; i6++) {
                            fArr[i6] = vectorValue.get$animation_core_release(i6);
                        }
                        fArr2 = fArr;
                    }
                } else {
                    if (i4 == getDurationMillis()) {
                        if (!this.keyframes.contains(i4)) {
                            fArr2 = new float[size$animation_core_release];
                            for (int i7 = 0; i7 < size$animation_core_release; i7++) {
                                fArr2[i7] = v2.get$animation_core_release(i7);
                            }
                        } else {
                            fArr = new float[size$animation_core_release];
                            VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo3 = this.keyframes.get(i4);
                            Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo3);
                            AnimationVector vectorValue2 = vectorizedKeyframeSpecElementInfo3.getVectorValue();
                            for (int i8 = 0; i8 < size$animation_core_release; i8++) {
                                fArr[i8] = vectorValue2.get$animation_core_release(i8);
                            }
                        }
                    } else {
                        fArr = new float[size$animation_core_release];
                        VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo4 = this.keyframes.get(i4);
                        Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo4);
                        AnimationVector vectorValue3 = vectorizedKeyframeSpecElementInfo4.getVectorValue();
                        for (int i9 = 0; i9 < size$animation_core_release; i9++) {
                            fArr[i9] = vectorValue3.get$animation_core_release(i9);
                        }
                    }
                    fArr2 = fArr;
                }
                fArr5[i3] = fArr2;
            }
            int[] iArr2 = this.modes;
            if (iArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("modes");
                iArr2 = null;
            }
            float[] fArr6 = this.times;
            if (fArr6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("times");
            } else {
                fArr4 = fArr6;
            }
            this.arcSpline = new ArcSpline(iArr2, fArr4, fArr5);
        }
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long j, @NotNull V v, @NotNull V v2, @NotNull V v3) {
        int iClampPlayTime = (int) VectorizedAnimationSpecKt.clampPlayTime(this, j / AnimationKt.MillisToNanos);
        if (this.keyframes.contains(iClampPlayTime)) {
            VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(iClampPlayTime);
            Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo);
            return (V) vectorizedKeyframeSpecElementInfo.getVectorValue();
        }
        if (iClampPlayTime >= getDurationMillis()) {
            return v2;
        }
        if (iClampPlayTime <= 0) {
            return v;
        }
        init(v, v2, v3);
        int i = 0;
        if (this.arcSpline != null) {
            float easedTime = getEasedTime(iClampPlayTime);
            ArcSpline arcSpline = this.arcSpline;
            if (arcSpline == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arcSpline");
                arcSpline = null;
            }
            float[] fArr = this.posArray;
            if (fArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("posArray");
                fArr = null;
            }
            arcSpline.getPos(easedTime, fArr);
            float[] fArr2 = this.posArray;
            if (fArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("posArray");
                fArr2 = null;
            }
            int length = fArr2.length;
            while (i < length) {
                V v4 = this.valueVector;
                if (v4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                    v4 = null;
                }
                float[] fArr3 = this.posArray;
                if (fArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("posArray");
                    fArr3 = null;
                }
                v4.set$animation_core_release(i, fArr3[i]);
                i++;
            }
            V v5 = this.valueVector;
            if (v5 != null) {
                return v5;
            }
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            return null;
        }
        int iFindEntryForTimeMillis = findEntryForTimeMillis(iClampPlayTime);
        float easedTimeFromIndex = getEasedTimeFromIndex(iFindEntryForTimeMillis, iClampPlayTime, true);
        int i2 = this.timestamps.get(iFindEntryForTimeMillis);
        if (this.keyframes.contains(i2)) {
            VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo2 = this.keyframes.get(i2);
            Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo2);
            v = (V) vectorizedKeyframeSpecElementInfo2.getVectorValue();
        }
        int i3 = this.timestamps.get(iFindEntryForTimeMillis + 1);
        if (this.keyframes.contains(i3)) {
            VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo3 = this.keyframes.get(i3);
            Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo3);
            v2 = (V) vectorizedKeyframeSpecElementInfo3.getVectorValue();
        }
        V v6 = this.valueVector;
        if (v6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            v6 = null;
        }
        int size$animation_core_release = v6.getSize$animation_core_release();
        while (i < size$animation_core_release) {
            V v7 = this.valueVector;
            if (v7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                v7 = null;
            }
            v7.set$animation_core_release(i, VectorConvertersKt.lerp(v.get$animation_core_release(i), v2.get$animation_core_release(i), easedTimeFromIndex));
            i++;
        }
        V v8 = this.valueVector;
        if (v8 != null) {
            return v8;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long j, @NotNull V v, @NotNull V v2, @NotNull V v3) {
        long jClampPlayTime = VectorizedAnimationSpecKt.clampPlayTime(this, j / AnimationKt.MillisToNanos);
        if (jClampPlayTime < 0) {
            return v3;
        }
        init(v, v2, v3);
        int i = 0;
        if (this.arcSpline != null) {
            float easedTime = getEasedTime((int) jClampPlayTime);
            ArcSpline arcSpline = this.arcSpline;
            if (arcSpline == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arcSpline");
                arcSpline = null;
            }
            float[] fArr = this.slopeArray;
            if (fArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("slopeArray");
                fArr = null;
            }
            arcSpline.getSlope(easedTime, fArr);
            float[] fArr2 = this.slopeArray;
            if (fArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("slopeArray");
                fArr2 = null;
            }
            int length = fArr2.length;
            while (i < length) {
                V v4 = this.velocityVector;
                if (v4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                    v4 = null;
                }
                float[] fArr3 = this.slopeArray;
                if (fArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("slopeArray");
                    fArr3 = null;
                }
                v4.set$animation_core_release(i, fArr3[i]);
                i++;
            }
            V v5 = this.velocityVector;
            if (v5 != null) {
                return v5;
            }
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            return null;
        }
        AnimationVector valueFromMillis = VectorizedAnimationSpecKt.getValueFromMillis(this, jClampPlayTime - 1, v, v2, v3);
        AnimationVector valueFromMillis2 = VectorizedAnimationSpecKt.getValueFromMillis(this, jClampPlayTime, v, v2, v3);
        int size$animation_core_release = valueFromMillis.getSize$animation_core_release();
        while (i < size$animation_core_release) {
            V v6 = this.velocityVector;
            if (v6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                v6 = null;
            }
            v6.set$animation_core_release(i, (valueFromMillis.get$animation_core_release(i) - valueFromMillis2.get$animation_core_release(i)) * 1000.0f);
            i++;
        }
        V v7 = this.velocityVector;
        if (v7 != null) {
            return v7;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }

    private final float getEasedTime(int i) {
        return getEasedTimeFromIndex(findEntryForTimeMillis(i), i, false);
    }

    private final float getEasedTimeFromIndex(int i, int i2, boolean z) {
        Easing easing;
        float f;
        IntList intList = this.timestamps;
        if (i >= intList._size - 1) {
            f = i2;
        } else {
            int i3 = intList.get(i);
            int i4 = this.timestamps.get(i + 1);
            if (i2 == i3) {
                f = i3;
            } else {
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(i3);
                if (vectorizedKeyframeSpecElementInfo == null || (easing = vectorizedKeyframeSpecElementInfo.getEasing()) == null) {
                    easing = this.defaultEasing;
                }
                float f2 = i4 - i3;
                float fTransform = easing.transform((i2 - i3) / f2);
                if (z) {
                    return fTransform;
                }
                f = (f2 * fTransform) + i3;
            }
        }
        return f / 1000;
    }

    private final int findEntryForTimeMillis(int i) {
        int iBinarySearch$default = IntListExtensionKt.binarySearch$default(this.timestamps, i, 0, 0, 6, null);
        return iBinarySearch$default < -1 ? -(iBinarySearch$default + 2) : iBinarySearch$default;
    }
}
