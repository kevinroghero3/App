package androidx.compose.ui.node;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class DrawModifierNodeKt {
    public static final void invalidateDraw(@NotNull DrawModifierNode drawModifierNode) {
        if (drawModifierNode.getNode().isAttached()) {
            DelegatableNodeKt.m2648requireCoordinator64DMado(drawModifierNode, NodeKind.m2761constructorimpl(1)).invalidateLayer();
        }
    }
}
