package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.imageutils.BitmapUtil;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class KeepLastFrameCache implements BitmapFrameCache {
    public static final Companion Companion = new Companion(null);
    private static final int FRAME_NUMBER_UNSET = -1;
    private BitmapFrameCache.FrameCacheListener frameCacheListener;
    private CloseableReference<Bitmap> lastBitmapReference;
    private int lastFrameNumber = -1;

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void onFramePrepared(int i, @NotNull CloseableReference<Bitmap> bitmapReference, int i2) {
        Intrinsics.checkNotNullParameter(bitmapReference, "bitmapReference");
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public boolean isAnimationReady() {
        return BitmapFrameCache.DefaultImpls.isAnimationReady(this);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public boolean onAnimationPrepared(@NotNull Map<Integer, ? extends CloseableReference<Bitmap>> map) {
        return BitmapFrameCache.DefaultImpls.onAnimationPrepared(this, map);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public CloseableReference<Bitmap> getCachedFrame(int i) {
        CloseableReference<Bitmap> closeableReferenceCloneOrNull;
        synchronized (this) {
            closeableReferenceCloneOrNull = this.lastFrameNumber == i ? CloseableReference.cloneOrNull(this.lastBitmapReference) : null;
        }
        return closeableReferenceCloneOrNull;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public CloseableReference<Bitmap> getFallbackFrame(int i) {
        CloseableReference<Bitmap> closeableReferenceCloneOrNull;
        synchronized (this) {
            closeableReferenceCloneOrNull = CloseableReference.cloneOrNull(this.lastBitmapReference);
        }
        return closeableReferenceCloneOrNull;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public CloseableReference<Bitmap> getBitmapToReuseForFrame(int i, int i2, int i3) {
        CloseableReference<Bitmap> closeableReferenceCloneOrNull;
        synchronized (this) {
            try {
                closeableReferenceCloneOrNull = CloseableReference.cloneOrNull(this.lastBitmapReference);
                closeAndResetLastBitmapReference();
            } catch (Throwable th) {
                closeAndResetLastBitmapReference();
                throw th;
            }
        }
        return closeableReferenceCloneOrNull;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public boolean contains(int i) {
        boolean z;
        synchronized (this) {
            z = i == this.lastFrameNumber && CloseableReference.isValid(this.lastBitmapReference);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public int getSizeInBytes() {
        int sizeInBytes;
        synchronized (this) {
            CloseableReference<Bitmap> closeableReference = this.lastBitmapReference;
            if (closeableReference == null) {
                sizeInBytes = 0;
            } else {
                Intrinsics.checkNotNull(closeableReference);
                sizeInBytes = BitmapUtil.getSizeInBytes(closeableReference.get());
            }
        }
        return sizeInBytes;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void clear() {
        synchronized (this) {
            closeAndResetLastBitmapReference();
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void onFrameRendered(int i, @NotNull CloseableReference<Bitmap> bitmapReference, int i2) {
        BitmapFrameCache.FrameCacheListener frameCacheListener;
        synchronized (this) {
            Intrinsics.checkNotNullParameter(bitmapReference, "bitmapReference");
            if (this.lastBitmapReference != null) {
                Bitmap bitmap = bitmapReference.get();
                CloseableReference<Bitmap> closeableReference = this.lastBitmapReference;
                if (Intrinsics.areEqual(bitmap, closeableReference != null ? closeableReference.get() : null)) {
                    return;
                }
            }
            CloseableReference.closeSafely(this.lastBitmapReference);
            int i3 = this.lastFrameNumber;
            if (i3 != -1 && (frameCacheListener = this.frameCacheListener) != null) {
                frameCacheListener.onFrameEvicted(this, i3);
            }
            this.lastBitmapReference = CloseableReference.cloneOrNull(bitmapReference);
            BitmapFrameCache.FrameCacheListener frameCacheListener2 = this.frameCacheListener;
            if (frameCacheListener2 != null) {
                frameCacheListener2.onFrameCached(this, i);
            }
            this.lastFrameNumber = i;
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void setFrameCacheListener(@Nullable BitmapFrameCache.FrameCacheListener frameCacheListener) {
        this.frameCacheListener = frameCacheListener;
    }

    private final void closeAndResetLastBitmapReference() {
        BitmapFrameCache.FrameCacheListener frameCacheListener;
        synchronized (this) {
            int i = this.lastFrameNumber;
            if (i != -1 && (frameCacheListener = this.frameCacheListener) != null) {
                frameCacheListener.onFrameEvicted(this, i);
            }
            CloseableReference.closeSafely(this.lastBitmapReference);
            this.lastBitmapReference = null;
            this.lastFrameNumber = -1;
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
