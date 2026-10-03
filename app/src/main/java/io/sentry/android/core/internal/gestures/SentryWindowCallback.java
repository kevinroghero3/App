package io.sentry.android.core.internal.gestures;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.Window;
import androidx.core.view.GestureDetectorCompat;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SpanStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class SentryWindowCallback extends WindowCallbackAdapter {
    private final Window.Callback delegate;
    private final GestureDetectorCompat gestureDetector;
    private final SentryGestureListener gestureListener;
    private final MotionEventObtainer motionEventObtainer;
    private final SentryOptions options;

    public SentryWindowCallback(@NotNull Window.Callback callback, @NotNull Context context, @NotNull SentryGestureListener sentryGestureListener, @Nullable SentryOptions sentryOptions) {
        this(callback, new GestureDetectorCompat(context, sentryGestureListener, new Handler(Looper.getMainLooper())), sentryGestureListener, sentryOptions, new MotionEventObtainer() { // from class: io.sentry.android.core.internal.gestures.SentryWindowCallback.1
        });
    }

    SentryWindowCallback(@NotNull Window.Callback callback, @NotNull GestureDetectorCompat gestureDetectorCompat, @NotNull SentryGestureListener sentryGestureListener, @Nullable SentryOptions sentryOptions, @NotNull MotionEventObtainer motionEventObtainer) {
        super(callback);
        this.delegate = callback;
        this.gestureListener = sentryGestureListener;
        this.options = sentryOptions;
        this.gestureDetector = gestureDetectorCompat;
        this.motionEventObtainer = motionEventObtainer;
    }

    @Override // io.sentry.android.core.internal.gestures.WindowCallbackAdapter, android.view.Window.Callback
    public boolean dispatchTouchEvent(@Nullable MotionEvent motionEvent) {
        if (motionEvent != null) {
            MotionEvent motionEventObtain = this.motionEventObtainer.obtain(motionEvent);
            try {
                handleTouchEvent(motionEventObtain);
            } catch (Throwable th) {
                try {
                    if (this.options != null) {
                        this.options.getLogger().log(SentryLevel.ERROR, "Error dispatching touch event", th);
                    }
                } finally {
                    motionEventObtain.recycle();
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void handleTouchEvent(@NotNull MotionEvent motionEvent) {
        this.gestureDetector.onTouchEvent(motionEvent);
        if (motionEvent.getActionMasked() == 1) {
            this.gestureListener.onUp(motionEvent);
        }
    }

    public void stopTracking() {
        this.gestureListener.stopTracing(SpanStatus.CANCELLED);
    }

    public Window.Callback getDelegate() {
        return this.delegate;
    }

    interface MotionEventObtainer {
        default MotionEvent obtain(@NotNull MotionEvent motionEvent) {
            return MotionEvent.obtain(motionEvent);
        }
    }
}
