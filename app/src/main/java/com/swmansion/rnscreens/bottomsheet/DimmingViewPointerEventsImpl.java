package com.swmansion.rnscreens.bottomsheet;

import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class DimmingViewPointerEventsImpl implements ReactPointerEventsView {
    private final DimmingView dimmingView;

    public DimmingViewPointerEventsImpl(@NotNull DimmingView dimmingView) {
        Intrinsics.checkNotNullParameter(dimmingView, "dimmingView");
        this.dimmingView = dimmingView;
    }

    public final DimmingView getDimmingView() {
        return this.dimmingView;
    }

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    public PointerEvents getPointerEvents() {
        return this.dimmingView.getBlockGestures$react_native_screens_release() ? PointerEvents.AUTO : PointerEvents.NONE;
    }
}
