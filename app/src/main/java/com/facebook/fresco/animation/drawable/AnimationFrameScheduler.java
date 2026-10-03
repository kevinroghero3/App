package com.facebook.fresco.animation.drawable;

import android.os.SystemClock;
import com.facebook.fresco.animation.frame.FrameScheduler;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class AnimationFrameScheduler {
    private long expectedRenderTimeMs;
    private final FrameScheduler frameScheduler;
    private long frameSchedulingDelayMs;
    private long frameSchedulingOffsetMs;
    private int framesDropped;
    private int lastDrawnFrameNumber;
    private long lastFrameAnimationTimeDifferenceMs;
    private long lastFrameAnimationTimeMs;
    private long pauseTimeMs;
    private int pausedLastDrawnFrameNumber;
    private boolean running;
    private long startMs;

    public AnimationFrameScheduler(@NotNull FrameScheduler frameScheduler) {
        Intrinsics.checkNotNullParameter(frameScheduler, "frameScheduler");
        this.frameScheduler = frameScheduler;
        this.frameSchedulingDelayMs = 8L;
        this.lastDrawnFrameNumber = -1;
        this.pausedLastDrawnFrameNumber = -1;
    }

    public final boolean getRunning() {
        return this.running;
    }

    public final void setRunning(boolean z) {
        this.running = z;
    }

    public final long getFrameSchedulingDelayMs() {
        return this.frameSchedulingDelayMs;
    }

    public final void setFrameSchedulingDelayMs(long j) {
        this.frameSchedulingDelayMs = j;
    }

    public final long getFrameSchedulingOffsetMs() {
        return this.frameSchedulingOffsetMs;
    }

    public final void setFrameSchedulingOffsetMs(long j) {
        this.frameSchedulingOffsetMs = j;
    }

    public final int getLastDrawnFrameNumber() {
        return this.lastDrawnFrameNumber;
    }

    public final void setLastDrawnFrameNumber(int i) {
        this.lastDrawnFrameNumber = i;
    }

    private final long now() {
        return SystemClock.uptimeMillis();
    }

    public final void start() {
        if (this.running) {
            return;
        }
        long jNow = now();
        long j = jNow - this.pauseTimeMs;
        this.startMs = j;
        this.expectedRenderTimeMs = j;
        this.lastFrameAnimationTimeMs = jNow - this.lastFrameAnimationTimeDifferenceMs;
        this.lastDrawnFrameNumber = this.pausedLastDrawnFrameNumber;
        this.running = true;
    }

    public final void stop() {
        if (this.running) {
            long jNow = now();
            this.pauseTimeMs = jNow - this.startMs;
            this.lastFrameAnimationTimeDifferenceMs = jNow - this.lastFrameAnimationTimeMs;
            this.startMs = 0L;
            this.expectedRenderTimeMs = 0L;
            this.lastFrameAnimationTimeMs = -1L;
            this.lastDrawnFrameNumber = -1;
            this.running = false;
        }
    }

    public final int frameToDraw() {
        long jMax;
        long jNow = now();
        if (this.running) {
            jMax = (jNow - this.startMs) + this.frameSchedulingOffsetMs;
        } else {
            jMax = Math.max(this.lastFrameAnimationTimeMs, 0L);
        }
        int frameNumberToRender = this.frameScheduler.getFrameNumberToRender(jMax, this.lastFrameAnimationTimeMs);
        this.lastFrameAnimationTimeMs = jMax;
        return frameNumberToRender;
    }

    public final long nextRenderTime() {
        if (!this.running) {
            return -1L;
        }
        long targetRenderTimeForNextFrameMs = this.frameScheduler.getTargetRenderTimeForNextFrameMs(now() - this.startMs);
        if (targetRenderTimeForNextFrameMs != -1) {
            long j = targetRenderTimeForNextFrameMs + this.frameSchedulingDelayMs;
            this.expectedRenderTimeMs = this.startMs + j;
            return j;
        }
        this.running = false;
        return -1L;
    }

    public final boolean shouldRepeatAnimation() {
        return this.lastDrawnFrameNumber != -1 && now() >= this.expectedRenderTimeMs;
    }

    public final void onFrameDropped() {
        this.framesDropped++;
    }

    public final boolean infinite() {
        return this.frameScheduler.isInfiniteAnimation();
    }

    public final long loopDuration() {
        return this.frameScheduler.getLoopDurationMs();
    }
}
