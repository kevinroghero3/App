package com.swmansion.rnscreens.bottomsheet;

import android.view.MotionEvent;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.uimanager.JSPointerDispatcher;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.Deprecated;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetDialogRootView extends ReactViewGroup implements RootView {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "BottomSheetDialogRootView";
    private final EventDispatcher eventDispatcher;
    private JSPointerDispatcher jsPointerDispatcher;
    private final JSTouchDispatcher jsTouchDispatcher;
    private final ReactContext reactContext;

    @Override // com.facebook.react.uimanager.RootView
    public void handleException(@NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public final ReactContext getReactContext() {
        return this.reactContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetDialogRootView(@Nullable ReactContext reactContext, @NotNull EventDispatcher eventDispatcher) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        this.reactContext = reactContext;
        this.eventDispatcher = eventDispatcher;
        this.jsTouchDispatcher = new JSTouchDispatcher(this);
        if (ReactFeatureFlags.dispatchPointerEvents) {
            this.jsPointerDispatcher = new JSPointerDispatcher(this);
        }
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            getChildCount();
            getChildAt(0).layout(i, i2, i3, i4);
        }
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.jsTouchDispatcher.handleTouchEvent(event, this.eventDispatcher);
        JSPointerDispatcher jSPointerDispatcher = this.jsPointerDispatcher;
        if (jSPointerDispatcher != null) {
            jSPointerDispatcher.handleMotionEvent(event, this.eventDispatcher, true);
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.jsTouchDispatcher.handleTouchEvent(event, this.eventDispatcher);
        JSPointerDispatcher jSPointerDispatcher = this.jsPointerDispatcher;
        if (jSPointerDispatcher != null) {
            jSPointerDispatcher.handleMotionEvent(event, this.eventDispatcher, false);
        }
        super.onTouchEvent(event);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        JSPointerDispatcher jSPointerDispatcher = this.jsPointerDispatcher;
        if (jSPointerDispatcher != null) {
            jSPointerDispatcher.handleMotionEvent(event, this.eventDispatcher, true);
        }
        return super.onHoverEvent(event);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    public boolean onHoverEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        JSPointerDispatcher jSPointerDispatcher = this.jsPointerDispatcher;
        if (jSPointerDispatcher != null) {
            jSPointerDispatcher.handleMotionEvent(event, this.eventDispatcher, false);
        }
        return super.onHoverEvent(event);
    }

    @Override // com.facebook.react.uimanager.RootView
    public void onChildStartedNativeGesture(@Nullable View view, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.jsTouchDispatcher.onChildStartedNativeGesture(event, this.eventDispatcher);
        JSPointerDispatcher jSPointerDispatcher = this.jsPointerDispatcher;
        if (jSPointerDispatcher != null) {
            jSPointerDispatcher.onChildStartedNativeGesture(view, event, this.eventDispatcher);
        }
    }

    @Override // com.facebook.react.uimanager.RootView
    @Deprecated(message = "Deprecated by React Native")
    public void onChildStartedNativeGesture(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        throw new IllegalStateException("Deprecated onChildStartedNativeGesture was called");
    }

    @Override // com.facebook.react.uimanager.RootView
    public void onChildEndedNativeGesture(@NotNull View view, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        this.jsTouchDispatcher.onChildEndedNativeGesture(event, this.eventDispatcher);
        JSPointerDispatcher jSPointerDispatcher = this.jsPointerDispatcher;
        if (jSPointerDispatcher != null) {
            jSPointerDispatcher.onChildEndedNativeGesture();
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
