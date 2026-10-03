package com.facebook.fresco.animation.bitmap.preparation;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultBitmapFramePreparer implements BitmapFramePreparer {
    private final Class<DefaultBitmapFramePreparer> TAG;
    private final Bitmap.Config bitmapConfig;
    private final BitmapFrameRenderer bitmapFrameRenderer;
    private final ExecutorService executorService;
    private final SparseArray<Runnable> pendingFrameDecodeJobs;
    private final PlatformBitmapFactory platformBitmapFactory;

    public DefaultBitmapFramePreparer(@NotNull PlatformBitmapFactory platformBitmapFactory, @NotNull BitmapFrameRenderer bitmapFrameRenderer, @NotNull Bitmap.Config bitmapConfig, @NotNull ExecutorService executorService) {
        Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
        Intrinsics.checkNotNullParameter(bitmapFrameRenderer, "bitmapFrameRenderer");
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        this.platformBitmapFactory = platformBitmapFactory;
        this.bitmapFrameRenderer = bitmapFrameRenderer;
        this.bitmapConfig = bitmapConfig;
        this.executorService = executorService;
        this.TAG = DefaultBitmapFramePreparer.class;
        this.pendingFrameDecodeJobs = new SparseArray<>();
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer
    public boolean prepareFrame(@NotNull BitmapFrameCache bitmapFrameCache, @NotNull AnimationBackend animationBackend, int i) {
        Intrinsics.checkNotNullParameter(bitmapFrameCache, "bitmapFrameCache");
        Intrinsics.checkNotNullParameter(animationBackend, "animationBackend");
        int uniqueId = getUniqueId(animationBackend, i);
        synchronized (this.pendingFrameDecodeJobs) {
            if (this.pendingFrameDecodeJobs.get(uniqueId) != null) {
                FLog.v(this.TAG, "Already scheduled decode job for frame %d", Integer.valueOf(i));
                return true;
            }
            if (bitmapFrameCache.contains(i)) {
                FLog.v(this.TAG, "Frame %d is cached already.", Integer.valueOf(i));
                return true;
            }
            FrameDecodeRunnable frameDecodeRunnable = new FrameDecodeRunnable(this, animationBackend, bitmapFrameCache, i, uniqueId);
            this.pendingFrameDecodeJobs.put(uniqueId, frameDecodeRunnable);
            this.executorService.execute(frameDecodeRunnable);
            Unit unit = Unit.INSTANCE;
            return true;
        }
    }

    final class FrameDecodeRunnable implements Runnable {
        private final AnimationBackend animationBackend;
        private final BitmapFrameCache bitmapFrameCache;
        private final int frameId;
        private final int frameNumber;
        final /* synthetic */ DefaultBitmapFramePreparer this$0;

        public FrameDecodeRunnable(@NotNull DefaultBitmapFramePreparer defaultBitmapFramePreparer, @NotNull AnimationBackend animationBackend, BitmapFrameCache bitmapFrameCache, int i, int i2) {
            Intrinsics.checkNotNullParameter(animationBackend, "animationBackend");
            Intrinsics.checkNotNullParameter(bitmapFrameCache, "bitmapFrameCache");
            this.this$0 = defaultBitmapFramePreparer;
            this.animationBackend = animationBackend;
            this.bitmapFrameCache = bitmapFrameCache;
            this.frameNumber = i;
            this.frameId = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.bitmapFrameCache.contains(this.frameNumber)) {
                    FLog.v((Class<?>) this.this$0.TAG, "Frame %d is cached already.", Integer.valueOf(this.frameNumber));
                    SparseArray sparseArray = this.this$0.pendingFrameDecodeJobs;
                    DefaultBitmapFramePreparer defaultBitmapFramePreparer = this.this$0;
                    synchronized (sparseArray) {
                        defaultBitmapFramePreparer.pendingFrameDecodeJobs.remove(this.frameId);
                        Unit unit = Unit.INSTANCE;
                    }
                    return;
                }
                if (prepareFrameAndCache(this.frameNumber, 1)) {
                    FLog.v((Class<?>) this.this$0.TAG, "Prepared frame %d.", Integer.valueOf(this.frameNumber));
                } else {
                    FLog.e((Class<?>) this.this$0.TAG, "Could not prepare frame %d.", Integer.valueOf(this.frameNumber));
                }
                SparseArray sparseArray2 = this.this$0.pendingFrameDecodeJobs;
                DefaultBitmapFramePreparer defaultBitmapFramePreparer2 = this.this$0;
                synchronized (sparseArray2) {
                    defaultBitmapFramePreparer2.pendingFrameDecodeJobs.remove(this.frameId);
                    Unit unit2 = Unit.INSTANCE;
                }
            } catch (Throwable th) {
                SparseArray sparseArray3 = this.this$0.pendingFrameDecodeJobs;
                DefaultBitmapFramePreparer defaultBitmapFramePreparer3 = this.this$0;
                synchronized (sparseArray3) {
                    defaultBitmapFramePreparer3.pendingFrameDecodeJobs.remove(this.frameId);
                    Unit unit3 = Unit.INSTANCE;
                    throw th;
                }
            }
        }

        private final boolean prepareFrameAndCache(int i, int i2) {
            CloseableReference<Bitmap> bitmapToReuseForFrame;
            int i3 = 2;
            try {
                if (i2 == 1) {
                    bitmapToReuseForFrame = this.bitmapFrameCache.getBitmapToReuseForFrame(i, this.animationBackend.getIntrinsicWidth(), this.animationBackend.getIntrinsicHeight());
                } else {
                    if (i2 != 2) {
                        CloseableReference.closeSafely((CloseableReference<?>) null);
                        return false;
                    }
                    bitmapToReuseForFrame = this.this$0.platformBitmapFactory.createBitmap(this.animationBackend.getIntrinsicWidth(), this.animationBackend.getIntrinsicHeight(), this.this$0.bitmapConfig);
                    i3 = -1;
                }
                boolean zRenderFrameAndCache = renderFrameAndCache(i, bitmapToReuseForFrame, i2);
                CloseableReference.closeSafely(bitmapToReuseForFrame);
                return (zRenderFrameAndCache || i3 == -1) ? zRenderFrameAndCache : prepareFrameAndCache(i, i3);
            } catch (RuntimeException e) {
                FLog.w((Class<?>) this.this$0.TAG, "Failed to create frame bitmap", e);
                return false;
            } finally {
                CloseableReference.closeSafely((CloseableReference<?>) null);
            }
        }

        private final boolean renderFrameAndCache(int i, CloseableReference<Bitmap> closeableReference, int i2) {
            if (CloseableReference.isValid(closeableReference) && closeableReference != null) {
                BitmapFrameRenderer bitmapFrameRenderer = this.this$0.bitmapFrameRenderer;
                Bitmap bitmap = closeableReference.get();
                Intrinsics.checkNotNullExpressionValue(bitmap, "get(...)");
                if (bitmapFrameRenderer.renderFrame(i, bitmap)) {
                    FLog.v((Class<?>) this.this$0.TAG, "Frame %d ready.", Integer.valueOf(i));
                    synchronized (this.this$0.pendingFrameDecodeJobs) {
                        this.bitmapFrameCache.onFramePrepared(i, closeableReference, i2);
                        Unit unit = Unit.INSTANCE;
                    }
                    return true;
                }
            }
            return false;
        }
    }

    private final int getUniqueId(AnimationBackend animationBackend, int i) {
        return (animationBackend.hashCode() * 31) + i;
    }
}
