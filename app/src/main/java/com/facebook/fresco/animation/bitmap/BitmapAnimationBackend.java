package com.facebook.fresco.animation.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import androidx.collection.ScatterMapKt;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer;
import com.facebook.fresco.vito.options.RoundingOptions;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapAnimationBackend implements AnimationBackend, AnimationBackendDelegateWithInactivityCheck.InactivityListener {
    public static final int FRAME_TYPE_CACHED = 0;
    public static final int FRAME_TYPE_CREATED = 2;
    public static final int FRAME_TYPE_FALLBACK = 3;
    public static final int FRAME_TYPE_REUSED = 1;
    public static final int FRAME_TYPE_UNKNOWN = -1;
    private final AnimationInformation animationInformation;
    private AnimationBackend.Listener animationListener;
    private final Bitmap.Config bitmapConfig;
    private final BitmapFrameCache bitmapFrameCache;
    private final BitmapFramePreparationStrategy bitmapFramePreparationStrategy;
    private final BitmapFramePreparer bitmapFramePreparer;
    private final BitmapFrameRenderer bitmapFrameRenderer;
    private int bitmapHeight;
    private int bitmapWidth;
    private Rect bounds;
    private final float[] cornerRadii;
    private FrameListener frameListener;
    private final boolean isNewRenderImplementation;
    private final Matrix matrix;
    private final Paint paint;
    private final Path path;
    private int pathFrameNumber;
    private final PlatformBitmapFactory platformBitmapFactory;
    public static final Companion Companion = new Companion(null);
    private static final Class<BitmapAnimationBackend> TAG = BitmapAnimationBackend.class;

    /* JADX INFO: loaded from: classes2.dex */
    public interface FrameListener {
        void onDrawFrameStart(@NotNull BitmapAnimationBackend bitmapAnimationBackend, int i);

        void onFrameDrawn(@NotNull BitmapAnimationBackend bitmapAnimationBackend, int i, int i2);

        void onFrameDropped(@NotNull BitmapAnimationBackend bitmapAnimationBackend, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface FrameType {
    }

    public BitmapAnimationBackend(@NotNull PlatformBitmapFactory platformBitmapFactory, @NotNull BitmapFrameCache bitmapFrameCache, @NotNull AnimationInformation animationInformation, @NotNull BitmapFrameRenderer bitmapFrameRenderer, boolean z, @Nullable BitmapFramePreparationStrategy bitmapFramePreparationStrategy, @Nullable BitmapFramePreparer bitmapFramePreparer, @Nullable RoundingOptions roundingOptions) {
        float[] cornerRadii;
        Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
        Intrinsics.checkNotNullParameter(bitmapFrameCache, "bitmapFrameCache");
        Intrinsics.checkNotNullParameter(animationInformation, "animationInformation");
        Intrinsics.checkNotNullParameter(bitmapFrameRenderer, "bitmapFrameRenderer");
        this.platformBitmapFactory = platformBitmapFactory;
        this.bitmapFrameCache = bitmapFrameCache;
        this.animationInformation = animationInformation;
        this.bitmapFrameRenderer = bitmapFrameRenderer;
        this.isNewRenderImplementation = z;
        this.bitmapFramePreparationStrategy = bitmapFramePreparationStrategy;
        this.bitmapFramePreparer = bitmapFramePreparer;
        if (roundingOptions == null) {
            cornerRadii = null;
        } else if (roundingOptions.getCornerRadius() != 0.0f) {
            cornerRadii = new float[8];
            ArraysKt___ArraysJvmKt.fill$default(cornerRadii, roundingOptions.getCornerRadius(), 0, 0, 6, (Object) null);
        } else {
            cornerRadii = roundingOptions.getCornerRadii();
        }
        this.cornerRadii = cornerRadii;
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
        this.paint = new Paint(6);
        this.path = new Path();
        this.matrix = new Matrix();
        this.pathFrameNumber = -1;
        updateBitmapDimensions();
    }

    public /* synthetic */ BitmapAnimationBackend(PlatformBitmapFactory platformBitmapFactory, BitmapFrameCache bitmapFrameCache, AnimationInformation animationInformation, BitmapFrameRenderer bitmapFrameRenderer, boolean z, BitmapFramePreparationStrategy bitmapFramePreparationStrategy, BitmapFramePreparer bitmapFramePreparer, RoundingOptions roundingOptions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(platformBitmapFactory, bitmapFrameCache, animationInformation, bitmapFrameRenderer, z, bitmapFramePreparationStrategy, bitmapFramePreparer, (i & 128) != 0 ? null : roundingOptions);
    }

    public final float[] getCornerRadii() {
        return this.cornerRadii;
    }

    public final void setFrameListener(@Nullable FrameListener frameListener) {
        this.frameListener = frameListener;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        return this.animationInformation.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int i) {
        return this.animationInformation.getFrameDurationMs(i);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int width() {
        return this.animationInformation.width();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int height() {
        return this.animationInformation.height();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopDurationMs() {
        return this.animationInformation.getLoopDurationMs();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        return this.animationInformation.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(@NotNull Drawable parent, @NotNull Canvas canvas, int i) throws Throwable {
        BitmapFramePreparer bitmapFramePreparer;
        BitmapFramePreparationStrategy bitmapFramePreparationStrategy;
        FrameListener frameListener;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        FrameListener frameListener2 = this.frameListener;
        if (frameListener2 != null) {
            frameListener2.onDrawFrameStart(this, i);
        }
        boolean zDrawFrameOrFallback = drawFrameOrFallback(canvas, i, 0);
        if (!zDrawFrameOrFallback && (frameListener = this.frameListener) != null) {
            frameListener.onFrameDropped(this, i);
        }
        if (!this.isNewRenderImplementation && (bitmapFramePreparer = this.bitmapFramePreparer) != null && (bitmapFramePreparationStrategy = this.bitmapFramePreparationStrategy) != null) {
            BitmapFramePreparationStrategy.DefaultImpls.prepareFrames$default(bitmapFramePreparationStrategy, bitmapFramePreparer, this.bitmapFrameCache, this, i, null, 16, null);
        }
        return zDrawFrameOrFallback;
    }

    private final boolean drawFrameOrFallback(Canvas canvas, int i, int i2) throws Throwable {
        CloseableReference<Bitmap> bitmapFrame;
        CloseableReference<Bitmap> cachedFrame;
        boolean zDrawBitmapAndCache;
        try {
            int i3 = 1;
            if (this.isNewRenderImplementation) {
                BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.bitmapFramePreparationStrategy;
                bitmapFrame = bitmapFramePreparationStrategy != null ? bitmapFramePreparationStrategy.getBitmapFrame(i, canvas.getWidth(), canvas.getHeight()) : null;
                if (bitmapFrame != null) {
                    try {
                        if (bitmapFrame.isValid()) {
                            Bitmap bitmap = bitmapFrame.get();
                            Intrinsics.checkNotNullExpressionValue(bitmap, "get(...)");
                            drawBitmap(i, bitmap, canvas);
                            CloseableReference.closeSafely(bitmapFrame);
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        CloseableReference.closeSafely(bitmapFrame);
                        throw th;
                    }
                }
                BitmapFramePreparationStrategy bitmapFramePreparationStrategy2 = this.bitmapFramePreparationStrategy;
                if (bitmapFramePreparationStrategy2 != null) {
                    bitmapFramePreparationStrategy2.prepareFrames(canvas.getWidth(), canvas.getHeight(), null);
                }
                CloseableReference.closeSafely(bitmapFrame);
                return false;
            }
            if (i2 == 0) {
                cachedFrame = this.bitmapFrameCache.getCachedFrame(i);
                zDrawBitmapAndCache = drawBitmapAndCache(i, cachedFrame, canvas, 0);
            } else if (i2 == 1) {
                cachedFrame = this.bitmapFrameCache.getBitmapToReuseForFrame(i, this.bitmapWidth, this.bitmapHeight);
                if (!renderFrameInBitmap(i, cachedFrame) || !drawBitmapAndCache(i, cachedFrame, canvas, 1)) {
                    i3 = 0;
                }
                zDrawBitmapAndCache = i3;
                i3 = 2;
            } else if (i2 == 2) {
                try {
                    cachedFrame = this.platformBitmapFactory.createBitmap(this.bitmapWidth, this.bitmapHeight, this.bitmapConfig);
                    if (!renderFrameInBitmap(i, cachedFrame) || !drawBitmapAndCache(i, cachedFrame, canvas, 2)) {
                        i3 = 0;
                    }
                    zDrawBitmapAndCache = i3;
                    i3 = 3;
                } catch (RuntimeException e) {
                    FLog.w(TAG, "Failed to create frame bitmap", e);
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                    return false;
                }
            } else {
                if (i2 != 3) {
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                    return false;
                }
                cachedFrame = this.bitmapFrameCache.getFallbackFrame(i);
                zDrawBitmapAndCache = drawBitmapAndCache(i, cachedFrame, canvas, 3);
                i3 = -1;
            }
            CloseableReference.closeSafely(cachedFrame);
            return (zDrawBitmapAndCache || i3 == -1) ? zDrawBitmapAndCache : drawFrameOrFallback(canvas, i, i3);
        } catch (Throwable th2) {
            th = th2;
            bitmapFrame = null;
            CloseableReference.closeSafely(bitmapFrame);
            throw th;
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(@IntRange(from = 0, to = ScatterMapKt.Sentinel) int i) {
        this.paint.setAlpha(i);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setBounds(@Nullable Rect rect) {
        this.bounds = rect;
        this.bitmapFrameRenderer.setBounds(rect);
        updateBitmapDimensions();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicWidth() {
        return this.bitmapWidth;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicHeight() {
        return this.bitmapHeight;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        return this.bitmapFrameCache.getSizeInBytes();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        if (this.isNewRenderImplementation) {
            BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.bitmapFramePreparationStrategy;
            if (bitmapFramePreparationStrategy != null) {
                bitmapFramePreparationStrategy.clearFrames();
                return;
            }
            return;
        }
        this.bitmapFrameCache.clear();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void preloadAnimation() {
        BitmapFramePreparer bitmapFramePreparer;
        if (!this.isNewRenderImplementation && (bitmapFramePreparer = this.bitmapFramePreparer) != null) {
            BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.bitmapFramePreparationStrategy;
            if (bitmapFramePreparationStrategy != null) {
                bitmapFramePreparationStrategy.prepareFrames(bitmapFramePreparer, this.bitmapFrameCache, this, 0, new Function0() { // from class: com.facebook.fresco.animation.bitmap.BitmapAnimationBackend$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BitmapAnimationBackend.preloadAnimation$lambda$1(this.f$0);
                    }
                });
                return;
            }
            return;
        }
        BitmapFramePreparationStrategy bitmapFramePreparationStrategy2 = this.bitmapFramePreparationStrategy;
        if (bitmapFramePreparationStrategy2 != null) {
            bitmapFramePreparationStrategy2.prepareFrames(this.animationInformation.width(), this.animationInformation.height(), new Function0() { // from class: com.facebook.fresco.animation.bitmap.BitmapAnimationBackend$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BitmapAnimationBackend.preloadAnimation$lambda$2(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preloadAnimation$lambda$1(BitmapAnimationBackend this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnimationBackend.Listener listener = this$0.animationListener;
        if (listener != null) {
            listener.onAnimationLoaded();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preloadAnimation$lambda$2(BitmapAnimationBackend this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnimationBackend.Listener listener = this$0.animationListener;
        if (listener != null) {
            listener.onAnimationLoaded();
        }
        return Unit.INSTANCE;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.InactivityListener
    public void onInactive() {
        if (this.isNewRenderImplementation) {
            BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.bitmapFramePreparationStrategy;
            if (bitmapFramePreparationStrategy != null) {
                bitmapFramePreparationStrategy.onStop();
                return;
            }
            return;
        }
        clear();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAnimationListener(@Nullable AnimationBackend.Listener listener) {
        this.animationListener = listener;
    }

    private final void updateBitmapDimensions() {
        int intrinsicWidth = this.bitmapFrameRenderer.getIntrinsicWidth();
        this.bitmapWidth = intrinsicWidth;
        if (intrinsicWidth == -1) {
            Rect rect = this.bounds;
            this.bitmapWidth = rect != null ? rect.width() : -1;
        }
        int intrinsicHeight = this.bitmapFrameRenderer.getIntrinsicHeight();
        this.bitmapHeight = intrinsicHeight;
        if (intrinsicHeight == -1) {
            Rect rect2 = this.bounds;
            this.bitmapHeight = rect2 != null ? rect2.height() : -1;
        }
    }

    private final boolean renderFrameInBitmap(int i, CloseableReference<Bitmap> closeableReference) {
        if (closeableReference == null || !closeableReference.isValid()) {
            return false;
        }
        BitmapFrameRenderer bitmapFrameRenderer = this.bitmapFrameRenderer;
        Bitmap bitmap = closeableReference.get();
        Intrinsics.checkNotNullExpressionValue(bitmap, "get(...)");
        boolean zRenderFrame = bitmapFrameRenderer.renderFrame(i, bitmap);
        if (!zRenderFrame) {
            CloseableReference.closeSafely(closeableReference);
        }
        return zRenderFrame;
    }

    private final boolean updatePath(int i, Bitmap bitmap, float f, float f2) {
        if (this.cornerRadii == null) {
            return false;
        }
        if (i == this.pathFrameNumber) {
            return true;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.matrix.setRectToRect(new RectF(0.0f, 0.0f, this.bitmapWidth, this.bitmapHeight), new RectF(0.0f, 0.0f, f, f2), Matrix.ScaleToFit.FILL);
        bitmapShader.setLocalMatrix(this.matrix);
        this.paint.setShader(bitmapShader);
        this.path.addRoundRect(new RectF(0.0f, 0.0f, f, f2), this.cornerRadii, Path.Direction.CW);
        this.pathFrameNumber = i;
        return true;
    }

    private final void drawBitmap(int i, Bitmap bitmap, Canvas canvas) {
        Rect rect = this.bounds;
        if (rect == null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.paint);
        } else if (updatePath(i, bitmap, rect.width(), rect.height())) {
            canvas.drawPath(this.path, this.paint);
        } else {
            canvas.drawBitmap(bitmap, (Rect) null, rect, this.paint);
        }
    }

    private final boolean drawBitmapAndCache(int i, CloseableReference<Bitmap> closeableReference, Canvas canvas, int i2) {
        if (closeableReference == null || !CloseableReference.isValid(closeableReference)) {
            return false;
        }
        Bitmap bitmap = closeableReference.get();
        Intrinsics.checkNotNullExpressionValue(bitmap, "get(...)");
        drawBitmap(i, bitmap, canvas);
        if (i2 != 3 && !this.isNewRenderImplementation) {
            this.bitmapFrameCache.onFrameRendered(i, closeableReference, i2);
        }
        FrameListener frameListener = this.frameListener;
        if (frameListener == null) {
            return true;
        }
        frameListener.onFrameDrawn(this, i, i2);
        return true;
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
