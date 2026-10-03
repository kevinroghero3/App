package com.facebook.fresco.animation.backend;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import androidx.collection.ScatterMapKt;
import com.facebook.fresco.animation.backend.AnimationBackend;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class AnimationBackendDelegate<T extends AnimationBackend> implements AnimationBackend {
    private static final int ALPHA_UNSET = -1;
    public static final Companion Companion = new Companion(null);
    private T _animationBackend;
    private int alpha = -1;
    private Rect bounds;
    private ColorFilter colorFilter;

    public AnimationBackendDelegate(@Nullable T t) {
        this._animationBackend = t;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        T t = this._animationBackend;
        if (t == null) {
            return 0;
        }
        Intrinsics.checkNotNull(t);
        return t.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int i) {
        T t = this._animationBackend;
        if (t == null) {
            return 0;
        }
        Intrinsics.checkNotNull(t);
        return t.getFrameDurationMs(i);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopDurationMs() {
        T t = this._animationBackend;
        if (t == null) {
            return 0;
        }
        Intrinsics.checkNotNull(t);
        return t.getLoopDurationMs();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int width() {
        T t = this._animationBackend;
        if (t == null) {
            return 0;
        }
        Intrinsics.checkNotNull(t);
        return t.width();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int height() {
        T t = this._animationBackend;
        if (t == null) {
            return 0;
        }
        Intrinsics.checkNotNull(t);
        return t.height();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        T t = this._animationBackend;
        if (t == null) {
            return 0;
        }
        Intrinsics.checkNotNull(t);
        return t.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(@NotNull Drawable parent, @NotNull Canvas canvas, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        T t = this._animationBackend;
        return t != null && t.drawFrame(parent, canvas, i);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(@IntRange(from = 0, to = ScatterMapKt.Sentinel) int i) {
        T t = this._animationBackend;
        if (t != null) {
            t.setAlpha(i);
        }
        this.alpha = i;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        T t = this._animationBackend;
        if (t != null) {
            t.setColorFilter(colorFilter);
        }
        this.colorFilter = colorFilter;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setBounds(@NotNull Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        T t = this._animationBackend;
        if (t != null) {
            t.setBounds(bounds);
        }
        this.bounds = bounds;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        T t = this._animationBackend;
        if (t == null) {
            return 0;
        }
        Intrinsics.checkNotNull(t);
        return t.getSizeInBytes();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        T t = this._animationBackend;
        if (t != null) {
            t.clear();
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void preloadAnimation() {
        T t = this._animationBackend;
        if (t != null) {
            t.preloadAnimation();
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAnimationListener(@Nullable AnimationBackend.Listener listener) {
        T t = this._animationBackend;
        if (t != null) {
            t.setAnimationListener(listener);
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicWidth() {
        T t = this._animationBackend;
        if (t == null) {
            return -1;
        }
        Intrinsics.checkNotNull(t);
        return t.getIntrinsicWidth();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicHeight() {
        T t = this._animationBackend;
        if (t == null) {
            return -1;
        }
        Intrinsics.checkNotNull(t);
        return t.getIntrinsicHeight();
    }

    public final T getAnimationBackend() {
        return this._animationBackend;
    }

    public final void setAnimationBackend(@Nullable T t) {
        this._animationBackend = t;
        if (t != null) {
            Intrinsics.checkNotNull(t);
            applyBackendProperties(t);
        }
    }

    private final void applyBackendProperties(AnimationBackend animationBackend) {
        Rect rect = this.bounds;
        if (rect != null) {
            animationBackend.setBounds(rect);
        }
        int i = this.alpha;
        if (i >= 0 && i <= 255) {
            animationBackend.setAlpha(i);
        }
        ColorFilter colorFilter = this.colorFilter;
        if (colorFilter != null) {
            animationBackend.setColorFilter(colorFilter);
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
