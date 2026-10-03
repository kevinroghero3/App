package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.gesturehandler.react.eventbuilders.LongPressGestureHandlerEventDataBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class LongPressGestureHandler extends GestureHandler {
    public static final Companion Companion = new Companion(null);
    private static final float DEFAULT_MAX_DIST_DP = 10.0f;
    private static final long DEFAULT_MIN_DURATION_MS = 500;
    private static final boolean DEFAULT_SHOULD_CANCEL_WHEN_OUTSIDE = true;
    private int currentPointers;
    private final float defaultMaxDist;
    private Handler handler;
    private float maxDist;
    private long minDurationMs;
    private int numberOfPointersRequired;
    private long previousTime;
    private long startTime;
    private float startX;
    private float startY;

    public LongPressGestureHandler(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.minDurationMs = DEFAULT_MIN_DURATION_MS;
        setShouldCancelWhenOutside(true);
        float f = context.getResources().getDisplayMetrics().density * 10.0f;
        this.defaultMaxDist = f;
        this.maxDist = f;
        this.numberOfPointersRequired = 1;
    }

    public final long getMinDurationMs() {
        return this.minDurationMs;
    }

    public final void setMinDurationMs(long j) {
        this.minDurationMs = j;
    }

    public final int getDuration() {
        return (int) (this.previousTime - this.startTime);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void resetConfig() {
        super.resetConfig();
        this.minDurationMs = DEFAULT_MIN_DURATION_MS;
        this.maxDist = this.defaultMaxDist;
        setShouldCancelWhenOutside(true);
    }

    static /* synthetic */ Pair getAverageCoords$default(LongPressGestureHandler longPressGestureHandler, MotionEvent motionEvent, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return longPressGestureHandler.getAverageCoords(motionEvent, z);
    }

    private final Pair<Float, Float> getAverageCoords(MotionEvent motionEvent, boolean z) {
        if (!z) {
            IntRange intRangeUntil = RangesKt___RangesKt.until(0, motionEvent.getPointerCount());
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it2 = intRangeUntil.iterator();
            while (it2.hasNext()) {
                arrayList.add(Float.valueOf(motionEvent.getX(((IntIterator) it2).nextInt())));
            }
            float fAverageOfFloat = (float) CollectionsKt___CollectionsKt.averageOfFloat(arrayList);
            IntRange intRangeUntil2 = RangesKt___RangesKt.until(0, motionEvent.getPointerCount());
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil2, 10));
            Iterator<Integer> it3 = intRangeUntil2.iterator();
            while (it3.hasNext()) {
                arrayList2.add(Float.valueOf(motionEvent.getY(((IntIterator) it3).nextInt())));
            }
            return new Pair<>(Float.valueOf(fAverageOfFloat), Float.valueOf((float) CollectionsKt___CollectionsKt.averageOfFloat(arrayList2)));
        }
        int pointerCount = motionEvent.getPointerCount();
        float x = 0.0f;
        float y = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            if (i != motionEvent.getActionIndex()) {
                x += motionEvent.getX(i);
                y += motionEvent.getY(i);
            }
        }
        return new Pair<>(Float.valueOf(x / (motionEvent.getPointerCount() - 1)), Float.valueOf(y / (motionEvent.getPointerCount() - 1)));
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onHandle(@NotNull MotionEvent event, @NotNull MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (shouldActivateWithMouse(sourceEvent)) {
            if (getState() == 0) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                this.previousTime = jUptimeMillis;
                this.startTime = jUptimeMillis;
                begin();
                Pair averageCoords$default = getAverageCoords$default(this, sourceEvent, false, 2, null);
                float fFloatValue = ((Number) averageCoords$default.component1()).floatValue();
                float fFloatValue2 = ((Number) averageCoords$default.component2()).floatValue();
                this.startX = fFloatValue;
                this.startY = fFloatValue2;
                this.currentPointers++;
            }
            if (sourceEvent.getActionMasked() == 5) {
                this.currentPointers++;
                Pair averageCoords$default2 = getAverageCoords$default(this, sourceEvent, false, 2, null);
                float fFloatValue3 = ((Number) averageCoords$default2.component1()).floatValue();
                float fFloatValue4 = ((Number) averageCoords$default2.component2()).floatValue();
                this.startX = fFloatValue3;
                this.startY = fFloatValue4;
                if (this.currentPointers > this.numberOfPointersRequired) {
                    fail();
                    this.currentPointers = 0;
                }
            }
            if (getState() == 2 && this.currentPointers == this.numberOfPointersRequired && (sourceEvent.getActionMasked() == 0 || sourceEvent.getActionMasked() == 5)) {
                Handler handler = new Handler(Looper.getMainLooper());
                this.handler = handler;
                long j = this.minDurationMs;
                if (j > 0) {
                    Intrinsics.checkNotNull(handler);
                    handler.postDelayed(new Runnable() { // from class: com.swmansion.gesturehandler.core.LongPressGestureHandler$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.activate();
                        }
                    }, this.minDurationMs);
                } else if (j == 0) {
                    activate();
                }
            }
            if (sourceEvent.getActionMasked() == 1 || sourceEvent.getActionMasked() == 12) {
                this.currentPointers--;
                Handler handler2 = this.handler;
                if (handler2 != null) {
                    handler2.removeCallbacksAndMessages(null);
                    this.handler = null;
                }
                if (getState() == 4) {
                    end();
                    return;
                } else {
                    fail();
                    return;
                }
            }
            if (sourceEvent.getActionMasked() == 6) {
                int i = this.currentPointers - 1;
                this.currentPointers = i;
                if (i < this.numberOfPointersRequired && getState() != 4) {
                    fail();
                    this.currentPointers = 0;
                    return;
                }
                Pair<Float, Float> averageCoords = getAverageCoords(sourceEvent, true);
                float fFloatValue5 = averageCoords.component1().floatValue();
                float fFloatValue6 = averageCoords.component2().floatValue();
                this.startX = fFloatValue5;
                this.startY = fFloatValue6;
                return;
            }
            Pair averageCoords$default3 = getAverageCoords$default(this, sourceEvent, false, 2, null);
            float fFloatValue7 = ((Number) averageCoords$default3.component1()).floatValue();
            float fFloatValue8 = ((Number) averageCoords$default3.component2()).floatValue();
            float f = fFloatValue7 - this.startX;
            float f2 = fFloatValue8 - this.startY;
            float f3 = this.maxDist;
            if ((f * f) + (f2 * f2) > f3 * f3) {
                if (getState() == 4) {
                    cancel();
                } else {
                    fail();
                }
            }
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onStateChange(int i, int i2) {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.handler = null;
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void dispatchStateChange(int i, int i2) {
        this.previousTime = SystemClock.uptimeMillis();
        super.dispatchStateChange(i, i2);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void dispatchHandlerUpdate(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.previousTime = SystemClock.uptimeMillis();
        super.dispatchHandlerUpdate(event);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onReset() {
        super.onReset();
        this.currentPointers = 0;
    }

    public static final class Factory extends GestureHandler.Factory<LongPressGestureHandler> {
        public static final Companion Companion = new Companion(null);
        private static final String KEY_MAX_DIST = "maxDist";
        private static final String KEY_MIN_DURATION_MS = "minDurationMs";
        private static final String KEY_NUMBER_OF_POINTERS = "numberOfPointers";
        private final Class<LongPressGestureHandler> type = LongPressGestureHandler.class;
        private final String name = "LongPressGestureHandler";

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public Class<LongPressGestureHandler> getType() {
            return this.type;
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public String getName() {
            return this.name;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public LongPressGestureHandler create(@Nullable Context context) {
            Intrinsics.checkNotNull(context);
            return new LongPressGestureHandler(context);
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public void setConfig(@NotNull LongPressGestureHandler handler, @NotNull ReadableMap config) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            super.setConfig(handler, config);
            if (config.hasKey(KEY_MIN_DURATION_MS)) {
                handler.setMinDurationMs(config.getInt(KEY_MIN_DURATION_MS));
            }
            if (config.hasKey(KEY_MAX_DIST)) {
                handler.maxDist = PixelUtil.toPixelFromDIP(config.getDouble(KEY_MAX_DIST));
            }
            if (config.hasKey(KEY_NUMBER_OF_POINTERS)) {
                handler.setNumberOfPointers(config.getInt(KEY_NUMBER_OF_POINTERS));
            }
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public LongPressGestureHandlerEventDataBuilder createEventBuilder(@NotNull LongPressGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new LongPressGestureHandlerEventDataBuilder(handler);
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
