package com.facebook.fresco.animation.bitmap.preparation;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.AnimationCoordinator;
import com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.DynamicRenderingFps;
import com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader;
import com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoaderFactory;
import com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameResult;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class FrameLoaderStrategy implements BitmapFramePreparationStrategy {
    private final int animationHeight;
    private final AnimationInformation animationInformation;
    private final int animationWidth;
    private final BitmapFrameRenderer bitmapFrameRenderer;
    private final String cacheKey;
    private int currentFps;
    private final boolean downscaleFrameToDrawableDimensions;
    private final FrameLoaderStrategy$dynamicFpsRender$1 dynamicFpsRender;
    private FrameLoader frameLoader;
    private final FrameLoaderFactory frameLoaderFactory;
    private final int maxAnimationFps;

    /* JADX WARN: Type inference failed for: r2v5, types: [com.facebook.fresco.animation.bitmap.preparation.FrameLoaderStrategy$dynamicFpsRender$1] */
    public FrameLoaderStrategy(@Nullable String str, @NotNull AnimationInformation animationInformation, @NotNull BitmapFrameRenderer bitmapFrameRenderer, @NotNull FrameLoaderFactory frameLoaderFactory, boolean z) {
        Intrinsics.checkNotNullParameter(animationInformation, "animationInformation");
        Intrinsics.checkNotNullParameter(bitmapFrameRenderer, "bitmapFrameRenderer");
        Intrinsics.checkNotNullParameter(frameLoaderFactory, "frameLoaderFactory");
        this.animationInformation = animationInformation;
        this.bitmapFrameRenderer = bitmapFrameRenderer;
        this.frameLoaderFactory = frameLoaderFactory;
        this.downscaleFrameToDrawableDimensions = z;
        this.cacheKey = str == null ? String.valueOf(hashCode()) : str;
        this.animationWidth = animationInformation.width();
        this.animationHeight = animationInformation.height();
        int iFps = fps(animationInformation);
        this.maxAnimationFps = iFps;
        this.currentFps = iFps;
        this.dynamicFpsRender = new DynamicRenderingFps() { // from class: com.facebook.fresco.animation.bitmap.preparation.FrameLoaderStrategy$dynamicFpsRender$1
            private final int animationFps;

            {
                this.animationFps = this.this$0.maxAnimationFps;
            }

            @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.DynamicRenderingFps
            public int getAnimationFps() {
                return this.animationFps;
            }

            @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.DynamicRenderingFps
            public int getRenderingFps() {
                return this.this$0.currentFps;
            }

            @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.DynamicRenderingFps
            public void setRenderingFps(int i) {
                if (i != this.this$0.currentFps) {
                    FrameLoaderStrategy frameLoaderStrategy = this.this$0;
                    frameLoaderStrategy.currentFps = RangesKt___RangesKt.coerceIn(i, 1, frameLoaderStrategy.maxAnimationFps);
                    FrameLoader frameLoader = this.this$0.getFrameLoader();
                    if (frameLoader != null) {
                        frameLoader.compressToFps(this.this$0.currentFps);
                    }
                }
            }
        };
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy
    public void prepareFrames(@NotNull BitmapFramePreparer bitmapFramePreparer, @NotNull BitmapFrameCache bitmapFrameCache, @NotNull AnimationBackend animationBackend, int i, @Nullable Function0<Unit> function0) {
        BitmapFramePreparationStrategy.DefaultImpls.prepareFrames(this, bitmapFramePreparer, bitmapFrameCache, animationBackend, i, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLoader getFrameLoader() {
        if (this.frameLoader == null) {
            this.frameLoader = this.frameLoaderFactory.createBufferLoader(this.cacheKey, this.bitmapFrameRenderer, this.animationInformation);
        }
        return this.frameLoader;
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy
    public void prepareFrames(int i, int i2, @Nullable Function0<Unit> function0) {
        if (i <= 0 || i2 <= 0 || this.animationWidth <= 0 || this.animationHeight <= 0) {
            return;
        }
        FrameSize frameSizeCalculateFrameSize = calculateFrameSize(i, i2);
        FrameLoader frameLoader = getFrameLoader();
        if (frameLoader != null) {
            int width = frameSizeCalculateFrameSize.getWidth();
            int width2 = frameSizeCalculateFrameSize.getWidth();
            if (function0 == null) {
                function0 = new Function0() { // from class: com.facebook.fresco.animation.bitmap.preparation.FrameLoaderStrategy$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
            }
            frameLoader.prepareFrames(width, width2, function0);
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy
    public CloseableReference<Bitmap> getBitmapFrame(int i, int i2, int i3) {
        FrameSize frameSizeCalculateFrameSize = calculateFrameSize(i2, i3);
        FrameLoader frameLoader = getFrameLoader();
        FrameResult frame = frameLoader != null ? frameLoader.getFrame(i, frameSizeCalculateFrameSize.getWidth(), frameSizeCalculateFrameSize.getHeight()) : null;
        if (frame != null) {
            AnimationCoordinator.INSTANCE.onRenderFrame(this.dynamicFpsRender, frame);
        }
        if (frame != null) {
            return frame.getBitmapRef();
        }
        return null;
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy
    public void onStop() {
        FrameLoader frameLoader = getFrameLoader();
        if (frameLoader != null) {
            frameLoader.onStop();
        }
        clearFrames();
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy
    public void clearFrames() {
        FrameLoader frameLoader = getFrameLoader();
        if (frameLoader != null) {
            FrameLoaderFactory.Companion.saveUnusedFrame(this.cacheKey, frameLoader);
        }
        this.frameLoader = null;
    }

    private final FrameSize calculateFrameSize(int i, int i2) {
        if (!this.downscaleFrameToDrawableDimensions) {
            return new FrameSize(this.animationWidth, this.animationHeight);
        }
        int iCoerceAtMost = this.animationWidth;
        int iCoerceAtMost2 = this.animationHeight;
        if (i < iCoerceAtMost || i2 < iCoerceAtMost2) {
            double d = ((double) iCoerceAtMost) / ((double) iCoerceAtMost2);
            if (i2 > i) {
                iCoerceAtMost2 = RangesKt___RangesKt.coerceAtMost(i2, iCoerceAtMost2);
                iCoerceAtMost = (int) (((double) iCoerceAtMost2) * d);
            } else {
                iCoerceAtMost = RangesKt___RangesKt.coerceAtMost(i, iCoerceAtMost);
                iCoerceAtMost2 = (int) (((double) iCoerceAtMost) / d);
            }
        }
        return new FrameSize(iCoerceAtMost, iCoerceAtMost2);
    }

    private final int fps(AnimationInformation animationInformation) {
        return (int) RangesKt___RangesKt.coerceAtLeast(TimeUnit.SECONDS.toMillis(1L) / ((long) (animationInformation.getLoopDurationMs() / animationInformation.getFrameCount())), 1L);
    }
}
