package androidx.compose.ui.node;

import androidx.compose.ui.layout.LayoutCoordinates;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class PointerInputModifierNodeKt {
    public static final boolean isAttached(@NotNull PointerInputModifierNode pointerInputModifierNode) {
        return pointerInputModifierNode.getNode().isAttached();
    }

    public static final LayoutCoordinates getLayoutCoordinates(@NotNull PointerInputModifierNode pointerInputModifierNode) {
        return DelegatableNodeKt.m2648requireCoordinator64DMado(pointerInputModifierNode, NodeKind.m2761constructorimpl(16));
    }
}
