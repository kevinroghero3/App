package com.facebook.fresco.animation.bitmap;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface BitmapFrameCache {

    /* JADX INFO: loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static boolean isAnimationReady(@NotNull BitmapFrameCache bitmapFrameCache) {
            return false;
        }

        public static boolean onAnimationPrepared(@NotNull BitmapFrameCache bitmapFrameCache, @NotNull Map<Integer, ? extends CloseableReference<Bitmap>> frameBitmaps) {
            Intrinsics.checkNotNullParameter(frameBitmaps, "frameBitmaps");
            return true;
        }
    }

    public interface FrameCacheListener {
        void onFrameCached(@NotNull BitmapFrameCache bitmapFrameCache, int i);

        void onFrameEvicted(@NotNull BitmapFrameCache bitmapFrameCache, int i);
    }

    void clear();

    boolean contains(int i);

    CloseableReference<Bitmap> getBitmapToReuseForFrame(int i, int i2, int i3);

    CloseableReference<Bitmap> getCachedFrame(int i);

    CloseableReference<Bitmap> getFallbackFrame(int i);

    int getSizeInBytes();

    boolean isAnimationReady();

    boolean onAnimationPrepared(@NotNull Map<Integer, ? extends CloseableReference<Bitmap>> map);

    void onFramePrepared(int i, @NotNull CloseableReference<Bitmap> closeableReference, int i2);

    void onFrameRendered(int i, @NotNull CloseableReference<Bitmap> closeableReference, int i2);

    void setFrameCacheListener(@Nullable FrameCacheListener frameCacheListener);
}
