package com.facebook.imagepipeline.animated.util;

import android.graphics.Bitmap;
import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class AnimatedDrawableUtil {
    public static final Companion Companion = new Companion(null);
    private static final int FRAME_DURATION_MS_FOR_MIN = 100;
    private static final int MIN_FRAME_DURATION_MS = 11;

    @JvmStatic
    public static final boolean isOutsideRange(int i, int i2, int i3) {
        return Companion.isOutsideRange(i, i2, i3);
    }

    public final void fixFrameDurations(@NotNull int[] frameDurationMs) {
        Intrinsics.checkNotNullParameter(frameDurationMs, "frameDurationMs");
        int length = frameDurationMs.length;
        for (int i = 0; i < length; i++) {
            if (frameDurationMs[i] < 11) {
                frameDurationMs[i] = 100;
            }
        }
    }

    public final int getTotalDurationFromFrameDurations(@NotNull int[] frameDurationMs) {
        Intrinsics.checkNotNullParameter(frameDurationMs, "frameDurationMs");
        int i = 0;
        for (int i2 : frameDurationMs) {
            i += i2;
        }
        return i;
    }

    public final int[] getFrameTimeStampsFromDurations(@NotNull int[] frameDurationsMs) {
        Intrinsics.checkNotNullParameter(frameDurationsMs, "frameDurationsMs");
        int[] iArr = new int[frameDurationsMs.length];
        int length = frameDurationsMs.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = i;
            i += frameDurationsMs[i2];
        }
        return iArr;
    }

    public final int getFrameForTimestampMs(@Nullable int[] iArr, int i) {
        int iBinarySearch = Arrays.binarySearch(iArr, i);
        return iBinarySearch < 0 ? (-iBinarySearch) - 2 : iBinarySearch;
    }

    public final int getSizeOfBitmap(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return bitmap.getAllocationByteCount();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean isOutsideRange(int i, int i2, int i3) {
            return i == -1 || i2 == -1 || (i > i2 ? !(i3 >= i || i3 <= i2) : !(i3 >= i && i3 <= i2));
        }

        private Companion() {
        }
    }
}
