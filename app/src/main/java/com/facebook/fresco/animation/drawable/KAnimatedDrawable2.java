package com.facebook.fresco.animation.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.drawable.DrawableProperties;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.fresco.animation.frame.FrameScheduler;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class KAnimatedDrawable2 extends Drawable implements Animatable, DrawableWithCaches {
    private final AnimationFrameScheduler animatedFrameScheduler;
    private AnimationBackend animationBackend;
    private AnimationListener animationListener;
    private DrawListener drawListener;
    private final DrawableProperties drawableProperties;
    private final KAnimatedDrawable2$invalidateRunnable$1 invalidateRunnable;
    private volatile boolean isRunning;

    /* JADX INFO: loaded from: classes4.dex */
    public interface DrawListener {
        void onDraw(@NotNull KAnimatedDrawable2 kAnimatedDrawable2, @NotNull FrameScheduler frameScheduler, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.facebook.fresco.animation.drawable.KAnimatedDrawable2$invalidateRunnable$1] */
    public KAnimatedDrawable2(@NotNull AnimationBackend animationBackend) {
        Intrinsics.checkNotNullParameter(animationBackend, "animationBackend");
        this.animationBackend = animationBackend;
        this.animatedFrameScheduler = new AnimationFrameScheduler(new DropFramesFrameScheduler(this.animationBackend));
        this.animationListener = new BaseAnimationListener();
        DrawableProperties drawableProperties = new DrawableProperties();
        drawableProperties.applyTo(this);
        this.drawableProperties = drawableProperties;
        this.invalidateRunnable = new Runnable() { // from class: com.facebook.fresco.animation.drawable.KAnimatedDrawable2$invalidateRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                this.this$0.unscheduleSelf(this);
                this.this$0.invalidateSelf();
            }
        };
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.drawableProperties.setAlpha(i);
        this.animationBackend.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.drawableProperties.setColorFilter(colorFilter);
        this.animationBackend.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.animationBackend.getFrameCount() <= 0) {
            return;
        }
        this.animatedFrameScheduler.start();
        this.animationListener.onAnimationStart(this);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.animatedFrameScheduler.stop();
        this.animationListener.onAnimationStop(this);
        unscheduleSelf(this.invalidateRunnable);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.animatedFrameScheduler.getRunning();
    }

    @Override // com.facebook.drawable.base.DrawableWithCaches
    public void dropCaches() {
        this.animationBackend.clear();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NotNull Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        this.animationBackend.setBounds(bounds);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.animationBackend.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.animationBackend.getIntrinsicHeight();
    }

    public final int loopDurationMs() {
        return this.animationBackend.getLoopDurationMs();
    }

    public final int getFrameCount() {
        return this.animationBackend.getFrameCount();
    }

    public final int loopCount() {
        return this.animationBackend.getLoopCount();
    }

    public final void setFrameSchedulingDelayMs(long j) {
        this.animatedFrameScheduler.setFrameSchedulingDelayMs(j);
    }

    public final void setFrameSchedulingOffsetMs(long j) {
        this.animatedFrameScheduler.setFrameSchedulingOffsetMs(j);
    }

    public final void setAnimationListener(@Nullable AnimationListener animationListener) {
        if (animationListener == null) {
            animationListener = this.animationListener;
        }
        this.animationListener = animationListener;
    }

    public final void setDrawListener(@Nullable DrawListener drawListener) {
        this.drawListener = drawListener;
    }

    public final void setAnimationBackend(@Nullable AnimationBackend animationBackend) {
        if (animationBackend == null) {
            return;
        }
        stop();
        animationBackend.setBounds(getBounds());
        this.drawableProperties.applyTo(this);
        this.animationBackend = animationBackend;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int iFrameToDraw = this.animatedFrameScheduler.frameToDraw();
        if (iFrameToDraw == -1) {
            iFrameToDraw = this.animationBackend.getFrameCount() - 1;
            this.animatedFrameScheduler.setRunning(false);
            this.animationListener.onAnimationStop(this);
        } else if (iFrameToDraw == 0 && this.animatedFrameScheduler.shouldRepeatAnimation()) {
            this.animationListener.onAnimationRepeat(this);
        }
        if (this.animationBackend.drawFrame(this, canvas, iFrameToDraw)) {
            this.animationListener.onAnimationFrame(this, iFrameToDraw);
            this.animatedFrameScheduler.setLastDrawnFrameNumber(iFrameToDraw);
        } else {
            this.animatedFrameScheduler.onFrameDropped();
        }
        long jNextRenderTime = this.animatedFrameScheduler.nextRenderTime();
        if (jNextRenderTime != -1) {
            scheduleSelf(this.invalidateRunnable, jNextRenderTime);
        } else {
            this.animationListener.onAnimationStop(this);
            this.animatedFrameScheduler.setRunning(false);
        }
    }
}
