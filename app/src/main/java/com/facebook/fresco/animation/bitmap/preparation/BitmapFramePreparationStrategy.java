package com.facebook.fresco.animation.bitmap.preparation;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface BitmapFramePreparationStrategy {
    void clearFrames();

    CloseableReference<Bitmap> getBitmapFrame(int i, int i2, int i3);

    void onStop();

    void prepareFrames(int i, int i2, @Nullable Function0<Unit> function0);

    void prepareFrames(@NotNull BitmapFramePreparer bitmapFramePreparer, @NotNull BitmapFrameCache bitmapFrameCache, @NotNull AnimationBackend animationBackend, int i, @Nullable Function0<Unit> function0);

    public static final class DefaultImpls {
        public static void clearFrames(@NotNull BitmapFramePreparationStrategy bitmapFramePreparationStrategy) {
        }

        public static CloseableReference<Bitmap> getBitmapFrame(@NotNull BitmapFramePreparationStrategy bitmapFramePreparationStrategy, int i, int i2, int i3) {
            return null;
        }

        public static void onStop(@NotNull BitmapFramePreparationStrategy bitmapFramePreparationStrategy) {
        }

        public static void prepareFrames(@NotNull BitmapFramePreparationStrategy bitmapFramePreparationStrategy, int i, int i2, @Nullable Function0<Unit> function0) {
        }

        public static void prepareFrames(@NotNull BitmapFramePreparationStrategy bitmapFramePreparationStrategy, @NotNull BitmapFramePreparer bitmapFramePreparer, @NotNull BitmapFrameCache bitmapFrameCache, @NotNull AnimationBackend animationBackend, int i, @Nullable Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(bitmapFramePreparer, "bitmapFramePreparer");
            Intrinsics.checkNotNullParameter(bitmapFrameCache, "bitmapFrameCache");
            Intrinsics.checkNotNullParameter(animationBackend, "animationBackend");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void prepareFrames$default(BitmapFramePreparationStrategy bitmapFramePreparationStrategy, BitmapFramePreparer bitmapFramePreparer, BitmapFrameCache bitmapFrameCache, AnimationBackend animationBackend, int i, Function0 function0, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: prepareFrames");
            }
            if ((i2 & 16) != 0) {
                function0 = null;
            }
            bitmapFramePreparationStrategy.prepareFrames(bitmapFramePreparer, bitmapFrameCache, animationBackend, i, function0);
        }
    }
}
