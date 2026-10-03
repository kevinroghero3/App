package com.facebook.fresco.animation.frame;

import com.facebook.fresco.animation.backend.AnimationInformation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class DropFramesFrameScheduler implements FrameScheduler {
    public static final Companion Companion = new Companion(null);
    private static final int UNSET = -1;
    private long _loopDurationMs;
    private final AnimationInformation animationInformation;

    public DropFramesFrameScheduler(@NotNull AnimationInformation animationInformation) {
        Intrinsics.checkNotNullParameter(animationInformation, "animationInformation");
        this.animationInformation = animationInformation;
        this._loopDurationMs = -1L;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public int getFrameNumberToRender(long j, long j2) {
        long loopDurationMs = getLoopDurationMs();
        if (loopDurationMs == 0) {
            return getFrameNumberWithinLoop(0L);
        }
        if (isInfiniteAnimation() || j / loopDurationMs < this.animationInformation.getLoopCount()) {
            return getFrameNumberWithinLoop(j % loopDurationMs);
        }
        return -1;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getLoopDurationMs() {
        long j = this._loopDurationMs;
        if (j != -1) {
            return j;
        }
        this._loopDurationMs = 0L;
        int frameCount = this.animationInformation.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this._loopDurationMs += (long) this.animationInformation.getFrameDurationMs(i);
        }
        return this._loopDurationMs;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getTargetRenderTimeMs(int i) {
        long frameDurationMs = 0;
        for (int i2 = 0; i2 < i; i2++) {
            frameDurationMs += (long) this.animationInformation.getFrameDurationMs(i);
        }
        return frameDurationMs;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getTargetRenderTimeForNextFrameMs(long j) {
        long loopDurationMs = getLoopDurationMs();
        long frameDurationMs = 0;
        if (loopDurationMs == 0) {
            return -1L;
        }
        if (!isInfiniteAnimation() && j / loopDurationMs >= this.animationInformation.getLoopCount()) {
            return -1L;
        }
        long j2 = j % loopDurationMs;
        int frameCount = this.animationInformation.getFrameCount();
        for (int i = 0; i < frameCount && frameDurationMs <= j2; i++) {
            frameDurationMs += (long) this.animationInformation.getFrameDurationMs(i);
        }
        return j + (frameDurationMs - j2);
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public boolean isInfiniteAnimation() {
        return this.animationInformation.getLoopCount() == 0;
    }

    public final int getFrameNumberWithinLoop(long j) {
        int i = 0;
        long frameDurationMs = 0;
        while (true) {
            frameDurationMs += (long) this.animationInformation.getFrameDurationMs(i);
            if (j < frameDurationMs) {
                return i;
            }
            i++;
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
