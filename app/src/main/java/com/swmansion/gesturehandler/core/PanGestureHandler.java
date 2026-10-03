package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.gesturehandler.react.eventbuilders.PanGestureHandlerEventDataBuilder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class PanGestureHandler extends GestureHandler {
    public static final Companion Companion = new Companion(null);
    private static final long DEFAULT_ACTIVATE_AFTER_LONG_PRESS = 0;
    private static final float DEFAULT_ACTIVE_OFFSET_X_END = Float.MIN_VALUE;
    private static final float DEFAULT_ACTIVE_OFFSET_X_START = Float.MAX_VALUE;
    private static final float DEFAULT_ACTIVE_OFFSET_Y_END = Float.MIN_VALUE;
    private static final float DEFAULT_ACTIVE_OFFSET_Y_START = Float.MAX_VALUE;
    private static final boolean DEFAULT_AVERAGE_TOUCHES = false;
    private static final float DEFAULT_FAIL_OFFSET_X_END = Float.MAX_VALUE;
    private static final float DEFAULT_FAIL_OFFSET_X_START = Float.MIN_VALUE;
    private static final float DEFAULT_FAIL_OFFSET_Y_END = Float.MAX_VALUE;
    private static final float DEFAULT_FAIL_OFFSET_Y_START = Float.MIN_VALUE;
    private static final int DEFAULT_MAX_POINTERS = 10;
    private static final int DEFAULT_MIN_POINTERS = 1;
    private static final float DEFAULT_MIN_VELOCITY = Float.MAX_VALUE;
    private static final float DEFAULT_MIN_VELOCITY_X = Float.MAX_VALUE;
    private static final float DEFAULT_MIN_VELOCITY_Y = Float.MAX_VALUE;
    private static final float MAX_VALUE_IGNORE = Float.MIN_VALUE;
    private static final float MIN_VALUE_IGNORE = Float.MAX_VALUE;
    private long activateAfterLongPress;
    private boolean averageTouches;
    private final float defaultMinDist;
    private Handler handler;
    private float lastX;
    private float lastY;
    private float minDist;
    private float offsetX;
    private float offsetY;
    private float startX;
    private float startY;
    private VelocityTracker velocityTracker;
    private float velocityX;
    private float velocityY;
    private float activeOffsetXStart = Float.MAX_VALUE;
    private float activeOffsetXEnd = Float.MIN_VALUE;
    private float failOffsetXStart = Float.MIN_VALUE;
    private float failOffsetXEnd = Float.MAX_VALUE;
    private float activeOffsetYStart = Float.MAX_VALUE;
    private float activeOffsetYEnd = Float.MIN_VALUE;
    private float failOffsetYStart = Float.MIN_VALUE;
    private float failOffsetYEnd = Float.MAX_VALUE;
    private float minVelocityX = Float.MAX_VALUE;
    private float minVelocityY = Float.MAX_VALUE;
    private float minVelocity = Float.MAX_VALUE;
    private int minPointers = 1;
    private int maxPointers = 10;
    private final Runnable activateDelayed = new Runnable() { // from class: com.swmansion.gesturehandler.core.PanGestureHandler$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.activate();
        }
    };
    private StylusData stylusData = new StylusData(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 31, null);

    public PanGestureHandler(@Nullable Context context) {
        this.minDist = Float.MIN_VALUE;
        Intrinsics.checkNotNull(context);
        float scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.defaultMinDist = scaledTouchSlop;
        this.minDist = scaledTouchSlop;
    }

    public final float getVelocityX() {
        return this.velocityX;
    }

    public final float getVelocityY() {
        return this.velocityY;
    }

    public final float getTranslationX() {
        return (this.lastX - this.startX) + this.offsetX;
    }

    public final float getTranslationY() {
        return (this.lastY - this.startY) + this.offsetY;
    }

    public final StylusData getStylusData() {
        return this.stylusData;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void resetConfig() {
        super.resetConfig();
        this.activeOffsetXStart = Float.MAX_VALUE;
        this.activeOffsetXEnd = Float.MIN_VALUE;
        this.failOffsetXStart = Float.MIN_VALUE;
        this.failOffsetXEnd = Float.MAX_VALUE;
        this.activeOffsetYStart = Float.MAX_VALUE;
        this.activeOffsetYEnd = Float.MIN_VALUE;
        this.failOffsetYStart = Float.MIN_VALUE;
        this.failOffsetYEnd = Float.MAX_VALUE;
        this.minVelocityX = Float.MAX_VALUE;
        this.minVelocityY = Float.MAX_VALUE;
        this.minVelocity = Float.MAX_VALUE;
        this.minDist = this.defaultMinDist;
        this.minPointers = 1;
        this.maxPointers = 10;
        this.activateAfterLongPress = 0L;
        this.averageTouches = false;
    }

    private final boolean shouldActivate() {
        float f = (this.lastX - this.startX) + this.offsetX;
        float f2 = this.activeOffsetXStart;
        if (f2 != Float.MAX_VALUE && f < f2) {
            return true;
        }
        float f3 = this.activeOffsetXEnd;
        if (f3 != Float.MIN_VALUE && f > f3) {
            return true;
        }
        float f4 = (this.lastY - this.startY) + this.offsetY;
        float f5 = this.activeOffsetYStart;
        if (f5 != Float.MAX_VALUE && f4 < f5) {
            return true;
        }
        float f6 = this.activeOffsetYEnd;
        if (f6 != Float.MIN_VALUE && f4 > f6) {
            return true;
        }
        float f7 = this.minDist;
        if (f7 != Float.MAX_VALUE && (f * f) + (f4 * f4) >= f7 * f7) {
            return true;
        }
        float f8 = this.velocityX;
        float f9 = this.minVelocityX;
        if (f9 != Float.MAX_VALUE && ((f9 < 0.0f && f8 <= f9) || (0.0f <= f9 && f9 <= f8))) {
            return true;
        }
        float f10 = this.velocityY;
        float f11 = this.minVelocityY;
        if (f11 != Float.MAX_VALUE && ((f11 < 0.0f && f8 <= f11) || (0.0f <= f11 && f11 <= f8))) {
            return true;
        }
        float f12 = this.minVelocity;
        return f12 != Float.MAX_VALUE && (f8 * f8) + (f10 * f10) >= f12 * f12;
    }

    private final boolean shouldFail() {
        float f = (this.lastX - this.startX) + this.offsetX;
        float f2 = (this.lastY - this.startY) + this.offsetY;
        if (this.activateAfterLongPress > 0) {
            float f3 = this.defaultMinDist;
            if ((f * f) + (f2 * f2) > f3 * f3) {
                Handler handler = this.handler;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                return true;
            }
        }
        float f4 = this.failOffsetXStart;
        if (f4 != Float.MIN_VALUE && f < f4) {
            return true;
        }
        float f5 = this.failOffsetXEnd;
        if (f5 != Float.MAX_VALUE && f > f5) {
            return true;
        }
        float f6 = this.failOffsetYStart;
        if (f6 != Float.MIN_VALUE && f2 < f6) {
            return true;
        }
        float f7 = this.failOffsetYEnd;
        return f7 != Float.MAX_VALUE && f2 > f7;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onHandle(@NotNull MotionEvent event, @NotNull MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (shouldActivateWithMouse(sourceEvent)) {
            if (event.getToolType(0) == 2) {
                this.stylusData = StylusData.Companion.fromEvent(event);
            }
            int state = getState();
            int actionMasked = sourceEvent.getActionMasked();
            if (actionMasked == 5 || actionMasked == 6) {
                this.offsetX += this.lastX - this.startX;
                this.offsetY += this.lastY - this.startY;
                GestureUtils gestureUtils = GestureUtils.INSTANCE;
                this.lastX = gestureUtils.getLastPointerX(sourceEvent, this.averageTouches);
                float lastPointerY = gestureUtils.getLastPointerY(sourceEvent, this.averageTouches);
                this.lastY = lastPointerY;
                this.startX = this.lastX;
                this.startY = lastPointerY;
            } else {
                GestureUtils gestureUtils2 = GestureUtils.INSTANCE;
                this.lastX = gestureUtils2.getLastPointerX(sourceEvent, this.averageTouches);
                this.lastY = gestureUtils2.getLastPointerY(sourceEvent, this.averageTouches);
            }
            if (state == 0 && sourceEvent.getPointerCount() >= this.minPointers) {
                resetProgress();
                this.offsetX = 0.0f;
                this.offsetY = 0.0f;
                this.velocityX = 0.0f;
                this.velocityY = 0.0f;
                VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
                this.velocityTracker = velocityTrackerObtain;
                Companion.addVelocityMovement(velocityTrackerObtain, sourceEvent);
                begin();
                if (this.activateAfterLongPress > 0) {
                    if (this.handler == null) {
                        this.handler = new Handler(Looper.getMainLooper());
                    }
                    Handler handler = this.handler;
                    Intrinsics.checkNotNull(handler);
                    handler.postDelayed(this.activateDelayed, this.activateAfterLongPress);
                }
            } else {
                VelocityTracker velocityTracker = this.velocityTracker;
                if (velocityTracker != null) {
                    Companion.addVelocityMovement(velocityTracker, sourceEvent);
                    VelocityTracker velocityTracker2 = this.velocityTracker;
                    Intrinsics.checkNotNull(velocityTracker2);
                    velocityTracker2.computeCurrentVelocity(1000);
                    VelocityTracker velocityTracker3 = this.velocityTracker;
                    Intrinsics.checkNotNull(velocityTracker3);
                    this.velocityX = velocityTracker3.getXVelocity();
                    VelocityTracker velocityTracker4 = this.velocityTracker;
                    Intrinsics.checkNotNull(velocityTracker4);
                    this.velocityY = velocityTracker4.getYVelocity();
                }
            }
            if (actionMasked == 1 || actionMasked == 12) {
                if (state == 4) {
                    end();
                    return;
                } else {
                    fail();
                    return;
                }
            }
            if (actionMasked == 5 && sourceEvent.getPointerCount() > this.maxPointers) {
                if (state == 4) {
                    cancel();
                    return;
                } else {
                    fail();
                    return;
                }
            }
            if (actionMasked == 6 && state == 4 && sourceEvent.getPointerCount() < this.minPointers) {
                fail();
                return;
            }
            if (state == 2) {
                if (shouldFail()) {
                    fail();
                } else if (shouldActivate()) {
                    activate();
                }
            }
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void activate(boolean z) {
        if (getState() != 4) {
            resetProgress();
        }
        super.activate(z);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onCancel() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onReset() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
        this.stylusData = new StylusData(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 31, null);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void resetProgress() {
        this.startX = this.lastX;
        this.startY = this.lastY;
    }

    public static final class Factory extends GestureHandler.Factory<PanGestureHandler> {
        public static final Companion Companion = new Companion(null);
        private static final String KEY_ACTIVATE_AFTER_LONG_PRESS = "activateAfterLongPress";
        private static final String KEY_ACTIVE_OFFSET_X_END = "activeOffsetXEnd";
        private static final String KEY_ACTIVE_OFFSET_X_START = "activeOffsetXStart";
        private static final String KEY_ACTIVE_OFFSET_Y_END = "activeOffsetYEnd";
        private static final String KEY_ACTIVE_OFFSET_Y_START = "activeOffsetYStart";
        private static final String KEY_AVG_TOUCHES = "avgTouches";
        private static final String KEY_FAIL_OFFSET_RANGE_X_END = "failOffsetXEnd";
        private static final String KEY_FAIL_OFFSET_RANGE_X_START = "failOffsetXStart";
        private static final String KEY_FAIL_OFFSET_RANGE_Y_END = "failOffsetYEnd";
        private static final String KEY_FAIL_OFFSET_RANGE_Y_START = "failOffsetYStart";
        private static final String KEY_MAX_POINTERS = "maxPointers";
        private static final String KEY_MIN_DIST = "minDist";
        private static final String KEY_MIN_POINTERS = "minPointers";
        private static final String KEY_MIN_VELOCITY = "minVelocity";
        private static final String KEY_MIN_VELOCITY_X = "minVelocityX";
        private static final String KEY_MIN_VELOCITY_Y = "minVelocityY";
        private final Class<PanGestureHandler> type = PanGestureHandler.class;
        private final String name = "PanGestureHandler";

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public Class<PanGestureHandler> getType() {
            return this.type;
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public String getName() {
            return this.name;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public PanGestureHandler create(@Nullable Context context) {
            return new PanGestureHandler(context);
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public void setConfig(@NotNull PanGestureHandler handler, @NotNull ReadableMap config) {
            boolean z;
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            super.setConfig(handler, config);
            boolean z2 = true;
            if (config.hasKey(KEY_ACTIVE_OFFSET_X_START)) {
                handler.activeOffsetXStart = PixelUtil.toPixelFromDIP(config.getDouble(KEY_ACTIVE_OFFSET_X_START));
                z = true;
            } else {
                z = false;
            }
            if (config.hasKey(KEY_ACTIVE_OFFSET_X_END)) {
                handler.activeOffsetXEnd = PixelUtil.toPixelFromDIP(config.getDouble(KEY_ACTIVE_OFFSET_X_END));
                z = true;
            }
            if (config.hasKey(KEY_FAIL_OFFSET_RANGE_X_START)) {
                handler.failOffsetXStart = PixelUtil.toPixelFromDIP(config.getDouble(KEY_FAIL_OFFSET_RANGE_X_START));
                z = true;
            }
            if (config.hasKey(KEY_FAIL_OFFSET_RANGE_X_END)) {
                handler.failOffsetXEnd = PixelUtil.toPixelFromDIP(config.getDouble(KEY_FAIL_OFFSET_RANGE_X_END));
                z = true;
            }
            if (config.hasKey(KEY_ACTIVE_OFFSET_Y_START)) {
                handler.activeOffsetYStart = PixelUtil.toPixelFromDIP(config.getDouble(KEY_ACTIVE_OFFSET_Y_START));
                z = true;
            }
            if (config.hasKey(KEY_ACTIVE_OFFSET_Y_END)) {
                handler.activeOffsetYEnd = PixelUtil.toPixelFromDIP(config.getDouble(KEY_ACTIVE_OFFSET_Y_END));
                z = true;
            }
            if (config.hasKey(KEY_FAIL_OFFSET_RANGE_Y_START)) {
                handler.failOffsetYStart = PixelUtil.toPixelFromDIP(config.getDouble(KEY_FAIL_OFFSET_RANGE_Y_START));
                z = true;
            }
            if (config.hasKey(KEY_FAIL_OFFSET_RANGE_Y_END)) {
                handler.failOffsetYEnd = PixelUtil.toPixelFromDIP(config.getDouble(KEY_FAIL_OFFSET_RANGE_Y_END));
                z = true;
            }
            if (config.hasKey(KEY_MIN_VELOCITY)) {
                handler.minVelocity = PixelUtil.toPixelFromDIP(config.getDouble(KEY_MIN_VELOCITY));
                z = true;
            }
            if (config.hasKey(KEY_MIN_VELOCITY_X)) {
                handler.minVelocityX = PixelUtil.toPixelFromDIP(config.getDouble(KEY_MIN_VELOCITY_X));
                z = true;
            }
            if (config.hasKey(KEY_MIN_VELOCITY_Y)) {
                handler.minVelocityY = PixelUtil.toPixelFromDIP(config.getDouble(KEY_MIN_VELOCITY_Y));
            } else {
                z2 = z;
            }
            if (config.hasKey(KEY_MIN_DIST)) {
                handler.minDist = PixelUtil.toPixelFromDIP(config.getDouble(KEY_MIN_DIST));
            } else if (z2) {
                handler.minDist = Float.MAX_VALUE;
            }
            if (config.hasKey(KEY_MIN_POINTERS)) {
                handler.minPointers = config.getInt(KEY_MIN_POINTERS);
            }
            if (config.hasKey(KEY_MAX_POINTERS)) {
                handler.maxPointers = config.getInt(KEY_MAX_POINTERS);
            }
            if (config.hasKey(KEY_AVG_TOUCHES)) {
                handler.averageTouches = config.getBoolean(KEY_AVG_TOUCHES);
            }
            if (config.hasKey(KEY_ACTIVATE_AFTER_LONG_PRESS)) {
                handler.activateAfterLongPress = config.getInt(KEY_ACTIVATE_AFTER_LONG_PRESS);
            }
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public PanGestureHandlerEventDataBuilder createEventBuilder(@NotNull PanGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new PanGestureHandlerEventDataBuilder(handler);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addVelocityMovement(VelocityTracker velocityTracker, MotionEvent motionEvent) {
            float rawX = motionEvent.getRawX() - motionEvent.getX();
            float rawY = motionEvent.getRawY() - motionEvent.getY();
            motionEvent.offsetLocation(rawX, rawY);
            Intrinsics.checkNotNull(velocityTracker);
            velocityTracker.addMovement(motionEvent);
            motionEvent.offsetLocation(-rawX, -rawY);
        }
    }
}
