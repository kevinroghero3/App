package com.facebook.react.views.scroll;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class VelocityHelper {
    private VelocityTracker velocityTracker;
    private float xVelocity;
    private float yVelocity;

    public final float getXVelocity() {
        return this.xVelocity;
    }

    public final float getYVelocity() {
        return this.yVelocity;
    }

    public final void calculateVelocity(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(ev);
            int action = ev.getAction() & 255;
            if (action == 1 || action == 3) {
                velocityTracker.computeCurrentVelocity(1);
                this.xVelocity = velocityTracker.getXVelocity();
                this.yVelocity = velocityTracker.getYVelocity();
                velocityTracker.recycle();
                this.velocityTracker = null;
            }
        }
    }
}
