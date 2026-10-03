package com.swmansion.rnscreens.events;

import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.ScreenFragment;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ScreenEventEmitter {
    private final Screen screen;

    public ScreenEventEmitter(@NotNull Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        this.screen = screen;
    }

    public final Screen getScreen() {
        return this.screen;
    }

    public final EventDispatcher getReactEventDispatcher() {
        return this.screen.getReactEventDispatcher();
    }

    public final int getReactSurfaceId() {
        return UIManagerHelper.getSurfaceId(this.screen);
    }

    public final Unit dispatchOnWillAppear() {
        EventDispatcher reactEventDispatcher = getReactEventDispatcher();
        if (reactEventDispatcher == null) {
            return null;
        }
        reactEventDispatcher.dispatchEvent(new ScreenWillAppearEvent(getReactSurfaceId(), this.screen.getId()));
        return Unit.INSTANCE;
    }

    public final Unit dispatchOnAppear() {
        EventDispatcher reactEventDispatcher = getReactEventDispatcher();
        if (reactEventDispatcher == null) {
            return null;
        }
        reactEventDispatcher.dispatchEvent(new ScreenAppearEvent(getReactSurfaceId(), this.screen.getId()));
        return Unit.INSTANCE;
    }

    public final Unit dispatchOnWillDisappear() {
        EventDispatcher reactEventDispatcher = getReactEventDispatcher();
        if (reactEventDispatcher == null) {
            return null;
        }
        reactEventDispatcher.dispatchEvent(new ScreenWillDisappearEvent(getReactSurfaceId(), this.screen.getId()));
        return Unit.INSTANCE;
    }

    public final Unit dispatchOnDisappear() {
        EventDispatcher reactEventDispatcher = getReactEventDispatcher();
        if (reactEventDispatcher == null) {
            return null;
        }
        reactEventDispatcher.dispatchEvent(new ScreenDisappearEvent(getReactSurfaceId(), this.screen.getId()));
        return Unit.INSTANCE;
    }

    public final Unit dispatchOnDismissed() {
        EventDispatcher reactEventDispatcher = getReactEventDispatcher();
        if (reactEventDispatcher == null) {
            return null;
        }
        reactEventDispatcher.dispatchEvent(new ScreenDismissedEvent(getReactSurfaceId(), this.screen.getId()));
        return Unit.INSTANCE;
    }

    public final void dispatchTransitionProgress(float f, boolean z, boolean z2) {
        float fCoerceIn = RangesKt___RangesKt.coerceIn(f, 0.0f, 1.0f);
        short coalescingKey = ScreenFragment.Companion.getCoalescingKey(fCoerceIn);
        EventDispatcher reactEventDispatcher = getReactEventDispatcher();
        if (reactEventDispatcher != null) {
            reactEventDispatcher.dispatchEvent(new ScreenTransitionProgressEvent(getReactSurfaceId(), this.screen.getId(), fCoerceIn, z, z2, coalescingKey));
        }
    }
}
