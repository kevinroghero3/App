package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.gesturehandler.react.eventbuilders.TapGestureHandlerEventDataBuilder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class TapGestureHandler extends GestureHandler {
    public static final Companion Companion = new Companion(null);
    private static final long DEFAULT_MAX_DELAY_MS = 200;
    private static final long DEFAULT_MAX_DURATION_MS = 500;
    private static final int DEFAULT_MIN_NUMBER_OF_POINTERS = 1;
    private static final int DEFAULT_NUMBER_OF_TAPS = 1;
    private static final boolean DEFAULT_SHOULD_CANCEL_WHEN_OUTSIDE = true;
    private static final float MAX_VALUE_IGNORE = Float.MIN_VALUE;
    private Handler handler;
    private float lastX;
    private float lastY;
    private float offsetX;
    private float offsetY;
    private float startX;
    private float startY;
    private int tapsSoFar;
    private float maxDeltaX = Float.MIN_VALUE;
    private float maxDeltaY = Float.MIN_VALUE;
    private float maxDist = Float.MIN_VALUE;
    private long maxDurationMs = DEFAULT_MAX_DURATION_MS;
    private long maxDelayMs = DEFAULT_MAX_DELAY_MS;
    private int numberOfTaps = 1;
    private int minNumberOfPointers = 1;
    private int currentMaxNumberOfPointers = 1;
    private final Runnable failDelayed = new Runnable() { // from class: com.swmansion.gesturehandler.core.TapGestureHandler$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.fail();
        }
    };

    public TapGestureHandler() {
        setShouldCancelWhenOutside(true);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void resetConfig() {
        super.resetConfig();
        this.maxDeltaX = Float.MIN_VALUE;
        this.maxDeltaY = Float.MIN_VALUE;
        this.maxDist = Float.MIN_VALUE;
        this.maxDurationMs = DEFAULT_MAX_DURATION_MS;
        this.maxDelayMs = DEFAULT_MAX_DELAY_MS;
        this.numberOfTaps = 1;
        this.minNumberOfPointers = 1;
        setShouldCancelWhenOutside(true);
    }

    private final void startTap() {
        Handler handler = this.handler;
        if (handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        } else {
            Intrinsics.checkNotNull(handler);
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.handler;
        Intrinsics.checkNotNull(handler2);
        handler2.postDelayed(this.failDelayed, this.maxDurationMs);
    }

    private final void endTap() {
        Handler handler = this.handler;
        if (handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        } else {
            Intrinsics.checkNotNull(handler);
            handler.removeCallbacksAndMessages(null);
        }
        int i = this.tapsSoFar + 1;
        this.tapsSoFar = i;
        if (i == this.numberOfTaps && this.currentMaxNumberOfPointers >= this.minNumberOfPointers) {
            activate();
            return;
        }
        Handler handler2 = this.handler;
        Intrinsics.checkNotNull(handler2);
        handler2.postDelayed(this.failDelayed, this.maxDelayMs);
    }

    private final boolean shouldFail() {
        float f = (this.lastX - this.startX) + this.offsetX;
        if (this.maxDeltaX != Float.MIN_VALUE && Math.abs(f) > this.maxDeltaX) {
            return true;
        }
        float f2 = (this.lastY - this.startY) + this.offsetY;
        if (this.maxDeltaY != Float.MIN_VALUE && Math.abs(f2) > this.maxDeltaY) {
            return true;
        }
        float f3 = this.maxDist;
        return f3 != Float.MIN_VALUE && (f2 * f2) + (f * f) > f3 * f3;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onHandle(@NotNull MotionEvent event, @NotNull MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (shouldActivateWithMouse(sourceEvent)) {
            int state = getState();
            int actionMasked = sourceEvent.getActionMasked();
            if (state == 0) {
                this.offsetX = 0.0f;
                this.offsetY = 0.0f;
                GestureUtils gestureUtils = GestureUtils.INSTANCE;
                this.startX = gestureUtils.getLastPointerX(sourceEvent, true);
                this.startY = gestureUtils.getLastPointerY(sourceEvent, true);
            }
            if (actionMasked == 5 || actionMasked == 6) {
                this.offsetX += this.lastX - this.startX;
                this.offsetY += this.lastY - this.startY;
                GestureUtils gestureUtils2 = GestureUtils.INSTANCE;
                this.lastX = gestureUtils2.getLastPointerX(sourceEvent, true);
                float lastPointerY = gestureUtils2.getLastPointerY(sourceEvent, true);
                this.lastY = lastPointerY;
                this.startX = this.lastX;
                this.startY = lastPointerY;
            } else {
                GestureUtils gestureUtils3 = GestureUtils.INSTANCE;
                this.lastX = gestureUtils3.getLastPointerX(sourceEvent, true);
                this.lastY = gestureUtils3.getLastPointerY(sourceEvent, true);
            }
            if (this.currentMaxNumberOfPointers < sourceEvent.getPointerCount()) {
                this.currentMaxNumberOfPointers = sourceEvent.getPointerCount();
            }
            if (shouldFail()) {
                fail();
                return;
            }
            if (state == 0) {
                if (actionMasked == 0 || actionMasked == 11) {
                    begin();
                }
                startTap();
                return;
            }
            if (state == 2) {
                if (actionMasked != 0) {
                    if (actionMasked != 1) {
                        if (actionMasked != 11) {
                            if (actionMasked != 12) {
                                return;
                            }
                        }
                    }
                    endTap();
                    return;
                }
                startTap();
            }
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void activate(boolean z) {
        super.activate(z);
        end();
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
        this.tapsSoFar = 0;
        this.currentMaxNumberOfPointers = 0;
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public static final class Factory extends GestureHandler.Factory<TapGestureHandler> {
        public static final Companion Companion = new Companion(null);
        private static final String KEY_MAX_DELAY_MS = "maxDelayMs";
        private static final String KEY_MAX_DELTA_X = "maxDeltaX";
        private static final String KEY_MAX_DELTA_Y = "maxDeltaY";
        private static final String KEY_MAX_DIST = "maxDist";
        private static final String KEY_MAX_DURATION_MS = "maxDurationMs";
        private static final String KEY_MIN_POINTERS = "minPointers";
        private static final String KEY_NUMBER_OF_TAPS = "numberOfTaps";
        private final Class<TapGestureHandler> type = TapGestureHandler.class;
        private final String name = "TapGestureHandler";

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public Class<TapGestureHandler> getType() {
            return this.type;
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public String getName() {
            return this.name;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public TapGestureHandler create(@Nullable Context context) {
            return new TapGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public void setConfig(@NotNull TapGestureHandler handler, @NotNull ReadableMap config) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            super.setConfig(handler, config);
            if (config.hasKey(KEY_NUMBER_OF_TAPS)) {
                handler.numberOfTaps = config.getInt(KEY_NUMBER_OF_TAPS);
            }
            if (config.hasKey(KEY_MAX_DURATION_MS)) {
                handler.maxDurationMs = config.getInt(KEY_MAX_DURATION_MS);
            }
            if (config.hasKey(KEY_MAX_DELAY_MS)) {
                handler.maxDelayMs = config.getInt(KEY_MAX_DELAY_MS);
            }
            if (config.hasKey(KEY_MAX_DELTA_X)) {
                handler.maxDeltaX = PixelUtil.toPixelFromDIP(config.getDouble(KEY_MAX_DELTA_X));
            }
            if (config.hasKey(KEY_MAX_DELTA_Y)) {
                handler.maxDeltaY = PixelUtil.toPixelFromDIP(config.getDouble(KEY_MAX_DELTA_Y));
            }
            if (config.hasKey(KEY_MAX_DIST)) {
                handler.maxDist = PixelUtil.toPixelFromDIP(config.getDouble(KEY_MAX_DIST));
            }
            if (config.hasKey(KEY_MIN_POINTERS)) {
                handler.minNumberOfPointers = config.getInt(KEY_MIN_POINTERS);
            }
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public TapGestureHandlerEventDataBuilder createEventBuilder(@NotNull TapGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new TapGestureHandlerEventDataBuilder(handler);
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
    }
}
