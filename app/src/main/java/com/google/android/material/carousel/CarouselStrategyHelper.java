package com.google.android.material.carousel;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes5.dex */
final class CarouselStrategyHelper {
    static float addStart(float f, float f2, int i) {
        return i > 0 ? f + (f2 / 2.0f) : f;
    }

    static float updateCurPosition(float f, float f2, float f3, int i) {
        return i > 0 ? f2 + (f3 / 2.0f) : f;
    }

    private CarouselStrategyHelper() {
    }

    static float getExtraSmallSize(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_gone_size);
    }

    static float getSmallSizeMin(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
    }

    static float getSmallSizeMax(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
    }

    static KeylineState createKeylineState(@NonNull Context context, float f, float f2, @NonNull Arrangement arrangement, int i) {
        if (i == 1) {
            return createCenterAlignedKeylineState(context, f, f2, arrangement);
        }
        return createLeftAlignedKeylineState(context, f, f2, arrangement);
    }

    static KeylineState createLeftAlignedKeylineState(@NonNull Context context, float f, float f2, @NonNull Arrangement arrangement) {
        float fMin = Math.min(getExtraSmallSize(context) + f, arrangement.largeSize);
        float f3 = fMin / 2.0f;
        float fAddStart = addStart(0.0f, arrangement.largeSize, arrangement.largeCount);
        float fUpdateCurPosition = updateCurPosition(0.0f, addEnd(fAddStart, arrangement.largeSize, arrangement.largeCount), arrangement.largeSize, arrangement.largeCount);
        float fAddStart2 = addStart(fUpdateCurPosition, arrangement.mediumSize, arrangement.mediumCount);
        float fAddStart3 = addStart(updateCurPosition(fUpdateCurPosition, fAddStart2, arrangement.mediumSize, arrangement.mediumCount), arrangement.smallSize, arrangement.smallCount);
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(fMin, arrangement.largeSize, f);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(arrangement.smallSize, arrangement.largeSize, f);
        float childMaskPercentage3 = CarouselStrategy.getChildMaskPercentage(arrangement.mediumSize, arrangement.largeSize, f);
        KeylineState.Builder builderAddKeylineRange = new KeylineState.Builder(arrangement.largeSize, f2).addAnchorKeyline(0.0f - f3, childMaskPercentage, fMin).addKeylineRange(fAddStart, 0.0f, arrangement.largeSize, arrangement.largeCount, true);
        if (arrangement.mediumCount > 0) {
            builderAddKeylineRange.addKeyline(fAddStart2, childMaskPercentage3, arrangement.mediumSize);
        }
        int i = arrangement.smallCount;
        if (i > 0) {
            builderAddKeylineRange.addKeylineRange(fAddStart3, childMaskPercentage2, arrangement.smallSize, i);
        }
        builderAddKeylineRange.addAnchorKeyline(f3 + f2, childMaskPercentage, fMin);
        return builderAddKeylineRange.build();
    }

    static KeylineState createCenterAlignedKeylineState(@NonNull Context context, float f, float f2, @NonNull Arrangement arrangement) {
        float f3;
        float fMin = Math.min(getExtraSmallSize(context) + f, arrangement.largeSize);
        float f4 = fMin / 2.0f;
        float fAddStart = addStart(0.0f, arrangement.smallSize, arrangement.smallCount);
        float fUpdateCurPosition = updateCurPosition(0.0f, addEnd(fAddStart, arrangement.smallSize, (int) Math.floor(arrangement.smallCount / 2.0f)), arrangement.smallSize, arrangement.smallCount);
        float fAddStart2 = addStart(fUpdateCurPosition, arrangement.mediumSize, arrangement.mediumCount);
        float fUpdateCurPosition2 = updateCurPosition(fUpdateCurPosition, addEnd(fAddStart2, arrangement.mediumSize, (int) Math.floor(arrangement.mediumCount / 2.0f)), arrangement.mediumSize, arrangement.mediumCount);
        float fAddStart3 = addStart(fUpdateCurPosition2, arrangement.largeSize, arrangement.largeCount);
        float fUpdateCurPosition3 = updateCurPosition(fUpdateCurPosition2, addEnd(fAddStart3, arrangement.largeSize, arrangement.largeCount), arrangement.largeSize, arrangement.largeCount);
        float fAddStart4 = addStart(fUpdateCurPosition3, arrangement.mediumSize, arrangement.mediumCount);
        float fAddStart5 = addStart(updateCurPosition(fUpdateCurPosition3, addEnd(fAddStart4, arrangement.mediumSize, (int) Math.ceil(arrangement.mediumCount / 2.0f)), arrangement.mediumSize, arrangement.mediumCount), arrangement.smallSize, arrangement.smallCount);
        float f5 = f4 + f2;
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(fMin, arrangement.largeSize, f);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(arrangement.smallSize, arrangement.largeSize, f);
        float childMaskPercentage3 = CarouselStrategy.getChildMaskPercentage(arrangement.mediumSize, arrangement.largeSize, f);
        KeylineState.Builder builderAddAnchorKeyline = new KeylineState.Builder(arrangement.largeSize, f2).addAnchorKeyline(0.0f - f4, childMaskPercentage, fMin);
        int i = arrangement.smallCount;
        if (i > 0) {
            builderAddAnchorKeyline.addKeylineRange(fAddStart, childMaskPercentage2, arrangement.smallSize, (int) Math.floor(i / 2.0f));
        }
        int i2 = arrangement.mediumCount;
        if (i2 > 0) {
            builderAddAnchorKeyline.addKeylineRange(fAddStart2, childMaskPercentage3, arrangement.mediumSize, (int) Math.floor(i2 / 2.0f));
        }
        builderAddAnchorKeyline.addKeylineRange(fAddStart3, 0.0f, arrangement.largeSize, arrangement.largeCount, true);
        int i3 = arrangement.mediumCount;
        if (i3 > 0) {
            f3 = 2.0f;
            builderAddAnchorKeyline.addKeylineRange(fAddStart4, childMaskPercentage3, arrangement.mediumSize, (int) Math.ceil(i3 / 2.0f));
        } else {
            f3 = 2.0f;
        }
        int i4 = arrangement.smallCount;
        if (i4 > 0) {
            builderAddAnchorKeyline.addKeylineRange(fAddStart5, childMaskPercentage2, arrangement.smallSize, (int) Math.ceil(i4 / f3));
        }
        builderAddAnchorKeyline.addAnchorKeyline(f5, childMaskPercentage, fMin);
        return builderAddAnchorKeyline.build();
    }

    static int maxValue(int[] iArr) {
        int i = Integer.MIN_VALUE;
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }

    static float addEnd(float f, float f2, int i) {
        return f + (Math.max(0, i - 1) * f2);
    }
}
