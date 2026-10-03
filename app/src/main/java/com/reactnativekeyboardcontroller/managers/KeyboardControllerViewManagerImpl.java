package com.reactnativekeyboardcontroller.managers;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.reactnativekeyboardcontroller.events.FocusedInputLayoutChangedEvent;
import com.reactnativekeyboardcontroller.events.FocusedInputSelectionChangedEvent;
import com.reactnativekeyboardcontroller.events.FocusedInputTextChangedEvent;
import com.reactnativekeyboardcontroller.events.KeyboardTransitionEvent;
import com.reactnativekeyboardcontroller.listeners.WindowDimensionListener;
import com.reactnativekeyboardcontroller.views.EdgeToEdgeReactViewGroup;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class KeyboardControllerViewManagerImpl {
    public static final Companion Companion = new Companion(null);
    public static final String NAME = "KeyboardControllerView";
    private WindowDimensionListener listener;

    public final EdgeToEdgeReactViewGroup createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        if (this.listener == null) {
            WindowDimensionListener windowDimensionListener = new WindowDimensionListener(reactContext);
            this.listener = windowDimensionListener;
            windowDimensionListener.attachListener();
        }
        return new EdgeToEdgeReactViewGroup(reactContext);
    }

    public final void invalidate() {
        WindowDimensionListener windowDimensionListener = this.listener;
        if (windowDimensionListener != null) {
            windowDimensionListener.detachListener();
        }
        this.listener = null;
    }

    public final void setEnabled(@NotNull EdgeToEdgeReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setActive(z);
    }

    public final void setStatusBarTranslucent(@NotNull EdgeToEdgeReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarTranslucent(z);
    }

    public final void setNavigationBarTranslucent(@NotNull EdgeToEdgeReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNavigationBarTranslucent(z);
    }

    public final void setPreserveEdgeToEdge(@NotNull EdgeToEdgeReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPreserveEdgeToEdge(z);
    }

    public final void setEdgeToEdge(@NotNull EdgeToEdgeReactViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEdgeToEdge();
    }

    public final Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        KeyboardTransitionEvent.Companion companion = KeyboardTransitionEvent.Companion;
        Map<String, Object> mapOf = MapBuilder.of(companion.getMove().getValue(), MapBuilder.of("registrationName", "onKeyboardMove"), companion.getStart().getValue(), MapBuilder.of("registrationName", "onKeyboardMoveStart"), companion.getEnd().getValue(), MapBuilder.of("registrationName", "onKeyboardMoveEnd"), companion.getInteractive().getValue(), MapBuilder.of("registrationName", "onKeyboardMoveInteractive"), FocusedInputLayoutChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onFocusedInputLayoutChanged"), FocusedInputTextChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onFocusedInputTextChanged"), FocusedInputSelectionChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onFocusedInputSelectionChanged"));
        Intrinsics.checkNotNullExpressionValue(mapOf, "of(...)");
        return mapOf;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
