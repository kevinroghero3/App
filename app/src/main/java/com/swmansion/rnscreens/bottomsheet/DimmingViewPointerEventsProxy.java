package com.swmansion.rnscreens.bottomsheet;

import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class DimmingViewPointerEventsProxy implements ReactPointerEventsView {
    private DimmingViewPointerEventsImpl pointerEventsImpl;

    public DimmingViewPointerEventsProxy(@Nullable DimmingViewPointerEventsImpl dimmingViewPointerEventsImpl) {
        this.pointerEventsImpl = dimmingViewPointerEventsImpl;
    }

    public final DimmingViewPointerEventsImpl getPointerEventsImpl() {
        return this.pointerEventsImpl;
    }

    public final void setPointerEventsImpl(@Nullable DimmingViewPointerEventsImpl dimmingViewPointerEventsImpl) {
        this.pointerEventsImpl = dimmingViewPointerEventsImpl;
    }

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    public PointerEvents getPointerEvents() {
        PointerEvents pointerEvents;
        DimmingViewPointerEventsImpl dimmingViewPointerEventsImpl = this.pointerEventsImpl;
        return (dimmingViewPointerEventsImpl == null || (pointerEvents = dimmingViewPointerEventsImpl.getPointerEvents()) == null) ? PointerEvents.NONE : pointerEvents;
    }
}
