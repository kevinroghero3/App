package com.swmansion.rnscreens.stack.views;

import com.swmansion.rnscreens.ScreenStack;
import java.util.Collections;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ReverseFromIndex extends ChildrenDrawingOrderStrategyBase {
    private final int startIndex;

    public final int getStartIndex() {
        return this.startIndex;
    }

    public ReverseFromIndex(int i) {
        super(false, 1, null);
        this.startIndex = i;
    }

    @Override // com.swmansion.rnscreens.stack.views.ChildrenDrawingOrderStrategy
    public void apply(@NotNull List<ScreenStack.DrawingOp> drawingOperations) {
        Intrinsics.checkNotNullParameter(drawingOperations, "drawingOperations");
        if (isEnabled()) {
            int i = this.startIndex;
            for (int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(drawingOperations); i < lastIndex; lastIndex--) {
                Collections.swap(drawingOperations, i, lastIndex);
                i++;
            }
        }
    }
}
