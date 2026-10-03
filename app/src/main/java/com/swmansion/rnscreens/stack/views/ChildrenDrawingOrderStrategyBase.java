package com.swmansion.rnscreens.stack.views;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ChildrenDrawingOrderStrategyBase implements ChildrenDrawingOrderStrategy {
    private boolean enabled;

    public ChildrenDrawingOrderStrategyBase() {
        this(false, 1, null);
    }

    public ChildrenDrawingOrderStrategyBase(boolean z) {
        this.enabled = z;
    }

    public /* synthetic */ ChildrenDrawingOrderStrategyBase(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    @Override // com.swmansion.rnscreens.stack.views.ChildrenDrawingOrderStrategy
    public void enable() {
        this.enabled = true;
    }

    @Override // com.swmansion.rnscreens.stack.views.ChildrenDrawingOrderStrategy
    public void disable() {
        this.enabled = false;
    }

    @Override // com.swmansion.rnscreens.stack.views.ChildrenDrawingOrderStrategy
    public boolean isEnabled() {
        return this.enabled;
    }
}
