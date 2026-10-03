package com.swmansion.rnscreens.stack.views;

import com.swmansion.rnscreens.ScreenStack;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ReverseOrder extends ChildrenDrawingOrderStrategyBase {
    public ReverseOrder() {
        super(false, 1, null);
    }

    @Override // com.swmansion.rnscreens.stack.views.ChildrenDrawingOrderStrategy
    public void apply(@NotNull List<ScreenStack.DrawingOp> drawingOperations) {
        Intrinsics.checkNotNullParameter(drawingOperations, "drawingOperations");
        if (isEnabled()) {
            CollectionsKt___CollectionsJvmKt.reverse(drawingOperations);
        }
    }
}
