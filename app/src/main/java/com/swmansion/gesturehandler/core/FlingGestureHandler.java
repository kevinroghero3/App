package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.facebook.react.bridge.ReadableMap;
import com.swmansion.gesturehandler.react.eventbuilders.FlingGestureHandlerEventDataBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class FlingGestureHandler extends GestureHandler {
    public static final Companion Companion = new Companion(null);
    private static final double DEFAULT_ALIGNMENT_CONE = 30.0d;
    private static final int DEFAULT_DIRECTION = 1;
    private static final long DEFAULT_MAX_DURATION_MS = 800;
    private static final long DEFAULT_MIN_VELOCITY = 2000;
    private static final int DEFAULT_NUMBER_OF_TOUCHES_REQUIRED = 1;
    private static final double MAX_AXIAL_DEVIATION;
    private static final double MAX_DIAGONAL_DEVIATION;
    private Handler handler;
    private int maxNumberOfPointersSimultaneously;
    private VelocityTracker velocityTracker;
    private int numberOfPointersRequired = 1;
    private int direction = 1;
    private final long maxDurationMs = DEFAULT_MAX_DURATION_MS;
    private final long minVelocity = DEFAULT_MIN_VELOCITY;
    private final Runnable failDelayed = new Runnable() { // from class: com.swmansion.gesturehandler.core.FlingGestureHandler$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.fail();
        }
    };

    public final int getNumberOfPointersRequired() {
        return this.numberOfPointersRequired;
    }

    public final void setNumberOfPointersRequired(int i) {
        this.numberOfPointersRequired = i;
    }

    public final int getDirection() {
        return this.direction;
    }

    public final void setDirection(int i) {
        this.direction = i;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void resetConfig() {
        super.resetConfig();
        this.numberOfPointersRequired = 1;
        this.direction = 1;
    }

    private final void startFling(MotionEvent motionEvent) {
        this.velocityTracker = VelocityTracker.obtain();
        begin();
        this.maxNumberOfPointersSimultaneously = 1;
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

    private final boolean tryEndFling(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        addVelocityMovement(this.velocityTracker, motionEvent);
        Vector.Companion companion = Vector.Companion;
        VelocityTracker velocityTracker = this.velocityTracker;
        Intrinsics.checkNotNull(velocityTracker);
        Vector vectorFromVelocity = companion.fromVelocity(velocityTracker);
        Integer[] numArr = {2, 1, 4, 8};
        ArrayList arrayList = new ArrayList(4);
        for (int i = 0; i < 4; i++) {
            arrayList.add(Boolean.valueOf(tryEndFling$getVelocityAlignment(this, vectorFromVelocity, numArr[i].intValue(), MAX_AXIAL_DEVIATION)));
        }
        Integer[] numArr2 = {5, 9, 6, 10};
        ArrayList arrayList2 = new ArrayList(4);
        for (int i2 = 0; i2 < 4; i2++) {
            arrayList2.add(Boolean.valueOf(tryEndFling$getVelocityAlignment(this, vectorFromVelocity, numArr2[i2].intValue(), MAX_DIAGONAL_DEVIATION)));
        }
        if (arrayList.isEmpty()) {
            z = false;
            break;
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = false;
                break;
            }
            if (((Boolean) it2.next()).booleanValue()) {
                z = true;
                break;
            }
        }
        if (arrayList2.isEmpty()) {
            z2 = false;
            break;
        }
        Iterator it3 = arrayList2.iterator();
        while (true) {
            if (!it3.hasNext()) {
                z2 = false;
                break;
            }
            if (((Boolean) it3.next()).booleanValue()) {
                z2 = true;
                break;
            }
        }
        boolean z3 = vectorFromVelocity.getMagnitude() > ((double) this.minVelocity);
        if (this.maxNumberOfPointersSimultaneously != this.numberOfPointersRequired || (!z && !z2) || !z3) {
            return false;
        }
        Handler handler = this.handler;
        Intrinsics.checkNotNull(handler);
        handler.removeCallbacksAndMessages(null);
        activate();
        return true;
    }

    private static final boolean tryEndFling$getVelocityAlignment(FlingGestureHandler flingGestureHandler, Vector vector, int i, double d) {
        return (flingGestureHandler.direction & i) == i && vector.isSimilar(Vector.Companion.fromDirection(i), d);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void activate(boolean z) {
        super.activate(z);
        end();
    }

    private final void endFling(MotionEvent motionEvent) {
        if (tryEndFling(motionEvent)) {
            return;
        }
        fail();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onHandle(@NotNull MotionEvent event, @NotNull MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (shouldActivateWithMouse(sourceEvent)) {
            int state = getState();
            if (state == 0) {
                startFling(sourceEvent);
            }
            if (state == 2) {
                tryEndFling(sourceEvent);
                if (sourceEvent.getPointerCount() > this.maxNumberOfPointersSimultaneously) {
                    this.maxNumberOfPointersSimultaneously = sourceEvent.getPointerCount();
                }
                if (sourceEvent.getActionMasked() == 1) {
                    endFling(sourceEvent);
                }
            }
        }
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
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.velocityTracker = null;
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    private final void addVelocityMovement(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX() - motionEvent.getX();
        float rawY = motionEvent.getRawY() - motionEvent.getY();
        motionEvent.offsetLocation(rawX, rawY);
        Intrinsics.checkNotNull(velocityTracker);
        velocityTracker.addMovement(motionEvent);
        motionEvent.offsetLocation(-rawX, -rawY);
    }

    public static final class Factory extends GestureHandler.Factory<FlingGestureHandler> {
        public static final Companion Companion = new Companion(null);
        private static final String KEY_DIRECTION = "direction";
        private static final String KEY_NUMBER_OF_POINTERS = "numberOfPointers";
        private final Class<FlingGestureHandler> type = FlingGestureHandler.class;
        private final String name = "FlingGestureHandler";

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public Class<FlingGestureHandler> getType() {
            return this.type;
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public String getName() {
            return this.name;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public FlingGestureHandler create(@Nullable Context context) {
            return new FlingGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public void setConfig(@NotNull FlingGestureHandler handler, @NotNull ReadableMap config) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            super.setConfig(handler, config);
            if (config.hasKey(KEY_NUMBER_OF_POINTERS)) {
                handler.setNumberOfPointersRequired(config.getInt(KEY_NUMBER_OF_POINTERS));
            }
            if (config.hasKey(KEY_DIRECTION)) {
                handler.setDirection(config.getInt(KEY_DIRECTION));
            }
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public FlingGestureHandlerEventDataBuilder createEventBuilder(@NotNull FlingGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new FlingGestureHandlerEventDataBuilder(handler);
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

    static {
        GestureUtils gestureUtils = GestureUtils.INSTANCE;
        MAX_AXIAL_DEVIATION = gestureUtils.coneToDeviation(DEFAULT_ALIGNMENT_CONE);
        MAX_DIAGONAL_DEVIATION = gestureUtils.coneToDeviation(60.0d);
    }
}
