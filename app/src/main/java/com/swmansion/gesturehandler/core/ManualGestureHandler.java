package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.view.MotionEvent;
import com.swmansion.gesturehandler.react.eventbuilders.ManualGestureHandlerEventDataBuilder;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class ManualGestureHandler extends GestureHandler {
    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onHandle(@NotNull MotionEvent event, @NotNull MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (getState() == 0) {
            begin();
        }
    }

    public static final class Factory extends GestureHandler.Factory<ManualGestureHandler> {
        private final Class<ManualGestureHandler> type = ManualGestureHandler.class;
        private final String name = "ManualGestureHandler";

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public Class<ManualGestureHandler> getType() {
            return this.type;
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public String getName() {
            return this.name;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public ManualGestureHandler create(@Nullable Context context) {
            return new ManualGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public ManualGestureHandlerEventDataBuilder createEventBuilder(@NotNull ManualGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new ManualGestureHandlerEventDataBuilder(handler);
        }
    }
}
