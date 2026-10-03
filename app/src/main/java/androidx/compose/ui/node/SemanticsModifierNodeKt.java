package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class SemanticsModifierNodeKt {
    public static final void invalidateSemantics(@NotNull SemanticsModifierNode semanticsModifierNode) {
        DelegatableNodeKt.requireLayoutNode(semanticsModifierNode).invalidateSemantics$ui_release();
    }

    public static final boolean getUseMinimumTouchTarget(@NotNull SemanticsConfiguration semanticsConfiguration) {
        return SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsActions.INSTANCE.getOnClick()) != null;
    }

    public static final Rect touchBoundsInRoot(@NotNull Modifier.Node node, boolean z) {
        if (!node.getNode().isAttached()) {
            return Rect.Companion.getZero();
        }
        if (!z) {
            return LayoutCoordinatesKt.boundsInRoot(DelegatableNodeKt.m2648requireCoordinator64DMado(node, NodeKind.m2761constructorimpl(8)));
        }
        return DelegatableNodeKt.m2648requireCoordinator64DMado(node, NodeKind.m2761constructorimpl(8)).touchBoundsInRoot();
    }
}
