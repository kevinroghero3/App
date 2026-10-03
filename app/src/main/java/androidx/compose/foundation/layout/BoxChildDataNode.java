package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
final class BoxChildDataNode extends Modifier.Node implements ParentDataModifierNode {
    private Alignment alignment;
    private boolean matchParentSize;

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    public BoxChildDataNode modifyParentData(@NotNull Density density, @Nullable Object obj) {
        return this;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final void setAlignment(@NotNull Alignment alignment) {
        this.alignment = alignment;
    }

    public final boolean getMatchParentSize() {
        return this.matchParentSize;
    }

    public final void setMatchParentSize(boolean z) {
        this.matchParentSize = z;
    }

    public BoxChildDataNode(@NotNull Alignment alignment, boolean z) {
        this.alignment = alignment;
        this.matchParentSize = z;
    }
}
