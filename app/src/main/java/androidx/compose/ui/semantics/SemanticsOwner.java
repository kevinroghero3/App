package androidx.compose.ui.semantics;

import androidx.compose.ui.node.LayoutNode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class SemanticsOwner {
    public static final int $stable = 8;
    private final EmptySemanticsModifier outerSemanticsNode;
    private final LayoutNode rootNode;

    public SemanticsOwner(@NotNull LayoutNode layoutNode, @NotNull EmptySemanticsModifier emptySemanticsModifier) {
        this.rootNode = layoutNode;
        this.outerSemanticsNode = emptySemanticsModifier;
    }

    public final SemanticsNode getRootSemanticsNode() {
        return SemanticsNodeKt.SemanticsNode(this.rootNode, true);
    }

    public final SemanticsNode getUnmergedRootSemanticsNode() {
        return new SemanticsNode(this.outerSemanticsNode, false, this.rootNode, new SemanticsConfiguration());
    }
}
