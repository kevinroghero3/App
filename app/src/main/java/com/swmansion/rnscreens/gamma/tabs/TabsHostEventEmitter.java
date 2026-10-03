package com.swmansion.rnscreens.gamma.tabs;

import com.facebook.react.bridge.ReactContext;
import com.swmansion.rnscreens.gamma.common.BaseEventEmitter;
import com.swmansion.rnscreens.gamma.tabs.event.TabsHostNativeFocusChangeEvent;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class TabsHostEventEmitter extends BaseEventEmitter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostEventEmitter(@NotNull ReactContext reactContext, int i) {
        super(reactContext, i);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    public final void emitOnNativeFocusChange(@NotNull String tabKey) {
        Intrinsics.checkNotNullParameter(tabKey, "tabKey");
        getReactEventDispatcher().dispatchEvent(new TabsHostNativeFocusChangeEvent(getSurfaceId(), getViewTag(), tabKey));
    }
}
