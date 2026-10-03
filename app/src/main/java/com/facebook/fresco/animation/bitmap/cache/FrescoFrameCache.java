package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imageutils.BitmapUtil;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class FrescoFrameCache implements BitmapFrameCache {
    public static final Companion Companion = new Companion(null);
    private static final Class<?> TAG = FrescoFrameCache.class;
    private final AnimatedFrameCache animatedFrameCache;
    private final boolean enableBitmapReusing;
    private CloseableReference<CloseableImage> lastRenderedItem;
    private final SparseArray<CloseableReference<CloseableImage>> preparedPendingFrames;

    @JvmStatic
    public static final CloseableReference<Bitmap> convertToBitmapReferenceAndClose(@Nullable CloseableReference<CloseableImage> closeableReference) {
        return Companion.convertToBitmapReferenceAndClose(closeableReference);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public boolean isAnimationReady() {
        return false;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public boolean onAnimationPrepared(@NotNull Map<Integer, ? extends CloseableReference<Bitmap>> frameBitmaps) {
        Intrinsics.checkNotNullParameter(frameBitmaps, "frameBitmaps");
        return true;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void setFrameCacheListener(@Nullable BitmapFrameCache.FrameCacheListener frameCacheListener) {
    }

    public FrescoFrameCache(@NotNull AnimatedFrameCache animatedFrameCache, boolean z) {
        Intrinsics.checkNotNullParameter(animatedFrameCache, "animatedFrameCache");
        this.animatedFrameCache = animatedFrameCache;
        this.enableBitmapReusing = z;
        this.preparedPendingFrames = new SparseArray<>();
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public CloseableReference<Bitmap> getCachedFrame(int i) {
        CloseableReference<Bitmap> closeableReferenceConvertToBitmapReferenceAndClose;
        synchronized (this) {
            closeableReferenceConvertToBitmapReferenceAndClose = Companion.convertToBitmapReferenceAndClose(this.animatedFrameCache.get(i));
        }
        return closeableReferenceConvertToBitmapReferenceAndClose;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public CloseableReference<Bitmap> getFallbackFrame(int i) {
        CloseableReference<Bitmap> closeableReferenceConvertToBitmapReferenceAndClose;
        synchronized (this) {
            closeableReferenceConvertToBitmapReferenceAndClose = Companion.convertToBitmapReferenceAndClose(CloseableReference.cloneOrNull(this.lastRenderedItem));
        }
        return closeableReferenceConvertToBitmapReferenceAndClose;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public CloseableReference<Bitmap> getBitmapToReuseForFrame(int i, int i2, int i3) {
        synchronized (this) {
            if (!this.enableBitmapReusing) {
                return null;
            }
            return Companion.convertToBitmapReferenceAndClose(this.animatedFrameCache.getForReuse());
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public boolean contains(int i) {
        boolean zContains;
        synchronized (this) {
            zContains = this.animatedFrameCache.contains(i);
        }
        return zContains;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public int getSizeInBytes() {
        int bitmapSizeBytes;
        int preparedPendingFramesSizeBytes;
        synchronized (this) {
            bitmapSizeBytes = Companion.getBitmapSizeBytes(this.lastRenderedItem);
            preparedPendingFramesSizeBytes = getPreparedPendingFramesSizeBytes();
        }
        return bitmapSizeBytes + preparedPendingFramesSizeBytes;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void clear() {
        synchronized (this) {
            CloseableReference.closeSafely(this.lastRenderedItem);
            this.lastRenderedItem = null;
            int size = this.preparedPendingFrames.size();
            for (int i = 0; i < size; i++) {
                CloseableReference.closeSafely(this.preparedPendingFrames.valueAt(i));
            }
            this.preparedPendingFrames.clear();
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void onFrameRendered(int i, @NotNull CloseableReference<Bitmap> bitmapReference, int i2) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(bitmapReference, "bitmapReference");
            removePreparedReference(i);
            CloseableReference<CloseableImage> closeableReferenceCreateImageReference = null;
            try {
                closeableReferenceCreateImageReference = Companion.createImageReference(bitmapReference);
                if (closeableReferenceCreateImageReference != null) {
                    CloseableReference.closeSafely(this.lastRenderedItem);
                    this.lastRenderedItem = this.animatedFrameCache.cache(i, closeableReferenceCreateImageReference);
                }
                CloseableReference.closeSafely(closeableReferenceCreateImageReference);
            } catch (Throwable th) {
                CloseableReference.closeSafely(closeableReferenceCreateImageReference);
                throw th;
            }
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void onFramePrepared(int i, @NotNull CloseableReference<Bitmap> bitmapReference, int i2) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(bitmapReference, "bitmapReference");
            try {
                CloseableReference<CloseableImage> closeableReferenceCreateImageReference = Companion.createImageReference(bitmapReference);
                if (closeableReferenceCreateImageReference != null) {
                    CloseableReference<CloseableImage> closeableReferenceCache = this.animatedFrameCache.cache(i, closeableReferenceCreateImageReference);
                    if (CloseableReference.isValid(closeableReferenceCache)) {
                        CloseableReference.closeSafely(this.preparedPendingFrames.get(i));
                        this.preparedPendingFrames.put(i, closeableReferenceCache);
                        FLog.v(TAG, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.preparedPendingFrames);
                    }
                    CloseableReference.closeSafely(closeableReferenceCreateImageReference);
                    return;
                }
                CloseableReference.closeSafely(closeableReferenceCreateImageReference);
            } catch (Throwable th) {
                CloseableReference.closeSafely((CloseableReference<?>) null);
                throw th;
            }
        }
    }

    private final int getPreparedPendingFramesSizeBytes() {
        int bitmapSizeBytes;
        synchronized (this) {
            int size = this.preparedPendingFrames.size();
            bitmapSizeBytes = 0;
            for (int i = 0; i < size; i++) {
                bitmapSizeBytes += Companion.getBitmapSizeBytes(this.preparedPendingFrames.valueAt(i));
            }
        }
        return bitmapSizeBytes;
    }

    private final void removePreparedReference(int i) {
        synchronized (this) {
            CloseableReference<CloseableImage> closeableReference = this.preparedPendingFrames.get(i);
            if (closeableReference != null) {
                this.preparedPendingFrames.delete(i);
                CloseableReference.closeSafely(closeableReference);
                FLog.v(TAG, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.preparedPendingFrames);
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CloseableReference<Bitmap> convertToBitmapReferenceAndClose(@Nullable CloseableReference<CloseableImage> closeableReference) {
            try {
                if (CloseableReference.isValid(closeableReference)) {
                    Intrinsics.checkNotNull(closeableReference);
                    if (closeableReference.get() instanceof CloseableStaticBitmap) {
                        CloseableImage closeableImage = closeableReference.get();
                        Intrinsics.checkNotNull(closeableImage, "null cannot be cast to non-null type com.facebook.imagepipeline.image.CloseableStaticBitmap");
                        return ((CloseableStaticBitmap) closeableImage).cloneUnderlyingBitmapReference();
                    }
                }
                return null;
            } finally {
                CloseableReference.closeSafely(closeableReference);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getBitmapSizeBytes(CloseableReference<CloseableImage> closeableReference) {
            if (!CloseableReference.isValid(closeableReference)) {
                return 0;
            }
            Intrinsics.checkNotNull(closeableReference);
            return getBitmapSizeBytes(closeableReference.get());
        }

        private final int getBitmapSizeBytes(CloseableImage closeableImage) {
            if (closeableImage instanceof CloseableBitmap) {
                return BitmapUtil.getSizeInBytes(((CloseableBitmap) closeableImage).getUnderlyingBitmap());
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final CloseableReference<CloseableImage> createImageReference(CloseableReference<Bitmap> closeableReference) {
            CloseableStaticBitmap closeableStaticBitmapOf = CloseableStaticBitmap.of(closeableReference, ImmutableQualityInfo.FULL_QUALITY, 0);
            Intrinsics.checkNotNullExpressionValue(closeableStaticBitmapOf, "of(...)");
            return CloseableReference.of(closeableStaticBitmapOf);
        }
    }
}
