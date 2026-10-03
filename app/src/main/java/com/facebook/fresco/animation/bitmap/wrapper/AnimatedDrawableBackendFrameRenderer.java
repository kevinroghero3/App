package com.facebook.fresco.animation.bitmap.wrapper;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class AnimatedDrawableBackendFrameRenderer implements BitmapFrameRenderer {
    public static final Companion Companion = new Companion(null);
    private static final Class<?> TAG = AnimatedDrawableBackendFrameRenderer.class;
    private AnimatedDrawableBackend animatedDrawableBackend;
    private AnimatedImageCompositor animatedImageCompositor;
    private final BitmapFrameCache bitmapFrameCache;
    private final AnimatedImageCompositor.Callback callback;
    private final boolean isNewRenderImplementation;

    public AnimatedDrawableBackendFrameRenderer(@NotNull BitmapFrameCache bitmapFrameCache, @NotNull AnimatedDrawableBackend animatedDrawableBackend, boolean z) {
        Intrinsics.checkNotNullParameter(bitmapFrameCache, "bitmapFrameCache");
        Intrinsics.checkNotNullParameter(animatedDrawableBackend, "animatedDrawableBackend");
        this.bitmapFrameCache = bitmapFrameCache;
        this.animatedDrawableBackend = animatedDrawableBackend;
        this.isNewRenderImplementation = z;
        AnimatedImageCompositor.Callback callback = new AnimatedImageCompositor.Callback() { // from class: com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer$callback$1
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public void onIntermediateResult(int i, Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public CloseableReference<Bitmap> getCachedBitmap(int i) {
                return this.this$0.bitmapFrameCache.getCachedFrame(i);
            }
        };
        this.callback = callback;
        this.animatedImageCompositor = new AnimatedImageCompositor(this.animatedDrawableBackend, z, callback);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameRenderer
    public void setBounds(@Nullable Rect rect) {
        AnimatedDrawableBackend animatedDrawableBackendForNewBounds = this.animatedDrawableBackend.forNewBounds(rect);
        Intrinsics.checkNotNullExpressionValue(animatedDrawableBackendForNewBounds, "forNewBounds(...)");
        if (animatedDrawableBackendForNewBounds != this.animatedDrawableBackend) {
            this.animatedDrawableBackend = animatedDrawableBackendForNewBounds;
            this.animatedImageCompositor = new AnimatedImageCompositor(animatedDrawableBackendForNewBounds, this.isNewRenderImplementation, this.callback);
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameRenderer
    public int getIntrinsicWidth() {
        return this.animatedDrawableBackend.getWidth();
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameRenderer
    public int getIntrinsicHeight() {
        return this.animatedDrawableBackend.getHeight();
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameRenderer
    public boolean renderFrame(int i, @NotNull Bitmap targetBitmap) {
        Intrinsics.checkNotNullParameter(targetBitmap, "targetBitmap");
        try {
            this.animatedImageCompositor.renderFrame(i, targetBitmap);
            return true;
        } catch (IllegalStateException e) {
            FLog.e(TAG, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
