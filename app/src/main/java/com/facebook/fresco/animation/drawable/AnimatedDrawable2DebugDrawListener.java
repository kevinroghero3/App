package com.facebook.fresco.animation.drawable;

import com.facebook.common.logging.FLog;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.frame.FrameScheduler;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class AnimatedDrawable2DebugDrawListener implements AnimatedDrawable2.DrawListener {
    public static final Companion Companion = new Companion(null);
    private static final Class<?> TAG = AnimatedDrawable2DebugDrawListener.class;
    private int drawCalls;
    private int duplicateFrames;
    private int lastFrameNumber = -1;
    private int skippedFrames;

    @Override // com.facebook.fresco.animation.drawable.AnimatedDrawable2.DrawListener
    public void onDraw(@NotNull AnimatedDrawable2 animatedDrawable, @NotNull FrameScheduler frameScheduler, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        Intrinsics.checkNotNullParameter(animatedDrawable, "animatedDrawable");
        Intrinsics.checkNotNullParameter(frameScheduler, "frameScheduler");
        AnimationBackend animationBackend = animatedDrawable.getAnimationBackend();
        if (animationBackend != null) {
            int frameCount = animationBackend.getFrameCount();
            this.drawCalls++;
            int i2 = this.lastFrameNumber;
            int i3 = (i2 + 1) % frameCount;
            if (i3 != i) {
                if (i2 == i) {
                    this.duplicateFrames++;
                } else {
                    int i4 = (i - i3) % frameCount;
                    if (i4 < 0) {
                        i4 += frameCount;
                    }
                    this.skippedFrames += i4;
                }
            }
            this.lastFrameNumber = i;
            FLog.d(TAG, "draw: frame: %2d, drawn: %b, delay: %3d ms, rendering: %3d ms, prev: %3d ms ago, duplicates: %3d, skipped: %3d, draw calls: %4d, anim time: %6d ms, next start: %6d ms, next scheduled: %6d ms", Integer.valueOf(i), Boolean.valueOf(z), Long.valueOf((j2 % frameScheduler.getLoopDurationMs()) - frameScheduler.getTargetRenderTimeMs(i)), Long.valueOf(j5 - j4), Long.valueOf(j2 - j3), Integer.valueOf(this.duplicateFrames), Integer.valueOf(this.skippedFrames), Integer.valueOf(this.drawCalls), Long.valueOf(j2), Long.valueOf(j6), Long.valueOf(j7));
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
