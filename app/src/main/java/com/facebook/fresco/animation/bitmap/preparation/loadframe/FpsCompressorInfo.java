package com.facebook.fresco.animation.bitmap.preparation.loadframe;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class FpsCompressorInfo {
    private final int maxFpsLimit;

    public final float millisecondsToSeconds(int i) {
        return i / 1000.0f;
    }

    public FpsCompressorInfo(int i) {
        this.maxFpsLimit = i;
    }

    public final CompressionResult compress(int i, @NotNull Map<Integer, ? extends CloseableReference<Bitmap>> frameBitmaps, int i2) {
        Intrinsics.checkNotNullParameter(frameBitmaps, "frameBitmaps");
        return compressAnimation(frameBitmaps, calculateReducedIndexes(i, frameBitmaps.size(), i2));
    }

    public final Map<Integer, Integer> calculateReducedIndexes(int i, int i2, int i3) {
        float fCoerceAtLeast = RangesKt___RangesKt.coerceAtLeast(RangesKt___RangesKt.coerceAtMost(RangesKt___RangesKt.coerceAtLeast(i3, 1), this.maxFpsLimit) * millisecondsToSeconds(i), 0.0f);
        float f = i2;
        float fCoerceAtMost = f / RangesKt___RangesKt.coerceAtMost(fCoerceAtLeast, f);
        int i4 = 0;
        IntRange intRangeUntil = RangesKt___RangesKt.until(0, i2);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil, 10)), 16));
        for (Integer num : intRangeUntil) {
            int iIntValue = num.intValue();
            if (((int) (iIntValue % fCoerceAtMost)) == 0) {
                i4 = iIntValue;
            }
            linkedHashMap.put(num, Integer.valueOf(i4));
        }
        return linkedHashMap;
    }

    private final CompressionResult compressAnimation(Map<Integer, ? extends CloseableReference<Bitmap>> map, Map<Integer, Integer> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Integer, ? extends CloseableReference<Bitmap>> entry : map.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            CloseableReference<Bitmap> value = entry.getValue();
            Integer num = map2.get(Integer.valueOf(iIntValue));
            if (num != null) {
                if (linkedHashMap.containsKey(num)) {
                    arrayList.add(value);
                } else {
                    linkedHashMap.put(num, value);
                }
            }
        }
        return new CompressionResult(linkedHashMap, map2, arrayList);
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class CompressionResult {
        private final Map<Integer, CloseableReference<Bitmap>> compressedAnim;
        private final Map<Integer, Integer> realToReducedIndex;
        private final List<CloseableReference<Bitmap>> removedFrames;

        /* JADX WARN: Multi-variable type inference failed */
        public CompressionResult(@NotNull Map<Integer, ? extends CloseableReference<Bitmap>> compressedAnim, @NotNull Map<Integer, Integer> realToReducedIndex, @NotNull List<? extends CloseableReference<Bitmap>> removedFrames) {
            Intrinsics.checkNotNullParameter(compressedAnim, "compressedAnim");
            Intrinsics.checkNotNullParameter(realToReducedIndex, "realToReducedIndex");
            Intrinsics.checkNotNullParameter(removedFrames, "removedFrames");
            this.compressedAnim = compressedAnim;
            this.realToReducedIndex = realToReducedIndex;
            this.removedFrames = removedFrames;
        }

        public final Map<Integer, CloseableReference<Bitmap>> getCompressedAnim() {
            return this.compressedAnim;
        }

        public final Map<Integer, Integer> getRealToReducedIndex() {
            return this.realToReducedIndex;
        }

        public final List<CloseableReference<Bitmap>> getRemovedFrames() {
            return this.removedFrames;
        }
    }
}
