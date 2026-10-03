package com.swmansion.rnscreens.stack.views;

import com.swmansion.rnscreens.ScreenStack;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface ChildrenDrawingOrderStrategy {
    void apply(@NotNull List<ScreenStack.DrawingOp> list);

    void disable();

    void enable();

    boolean isEnabled();
}
