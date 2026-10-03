package com.swmansion.rnscreens.gamma.tabs;

import com.facebook.react.bridge.ReactContext;
import com.swmansion.rnscreens.gamma.common.BaseEventEmitter;
import com.swmansion.rnscreens.gamma.tabs.event.TabScreenDidAppearEvent;
import com.swmansion.rnscreens.gamma.tabs.event.TabScreenDidDisappearEvent;
import com.swmansion.rnscreens.gamma.tabs.event.TabScreenWillAppearEvent;
import com.swmansion.rnscreens.gamma.tabs.event.TabScreenWillDisappearEvent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class TabScreenEventEmitter extends BaseEventEmitter {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "TabScreenEventEmitter";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabScreenEventEmitter(@NotNull ReactContext reactContext, int i) {
        super(reactContext, i);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    public final void emitOnWillAppear() {
        TabScreenEventEmitterKt.logEventDispatch(getViewTag(), TabScreenWillAppearEvent.EVENT_REGISTRATION_NAME);
        getReactEventDispatcher().dispatchEvent(new TabScreenWillAppearEvent(getSurfaceId(), getViewTag()));
    }

    public final void emitOnDidAppear() {
        TabScreenEventEmitterKt.logEventDispatch(getViewTag(), TabScreenDidAppearEvent.EVENT_REGISTRATION_NAME);
        getReactEventDispatcher().dispatchEvent(new TabScreenDidAppearEvent(getSurfaceId(), getViewTag()));
    }

    public final void emitOnWillDisappear() {
        TabScreenEventEmitterKt.logEventDispatch(getViewTag(), TabScreenWillDisappearEvent.EVENT_REGISTRATION_NAME);
        getReactEventDispatcher().dispatchEvent(new TabScreenWillDisappearEvent(getSurfaceId(), getViewTag()));
    }

    public final void emitOnDidDisappear() {
        TabScreenEventEmitterKt.logEventDispatch(getViewTag(), TabScreenDidDisappearEvent.EVENT_REGISTRATION_NAME);
        getReactEventDispatcher().dispatchEvent(new TabScreenDidDisappearEvent(getSurfaceId(), getViewTag()));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
