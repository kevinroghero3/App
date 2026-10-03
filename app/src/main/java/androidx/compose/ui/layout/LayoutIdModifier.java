package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutIdModifier extends Modifier.Node implements ParentDataModifierNode, LayoutIdParentData {
    public static final int $stable = 8;
    private Object layoutId;

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    public Object modifyParentData(@NotNull Density density, @Nullable Object obj) {
        return this;
    }

    public LayoutIdModifier(@NotNull Object obj) {
        this.layoutId = obj;
    }

    @Override // androidx.compose.ui.layout.LayoutIdParentData
    public Object getLayoutId() {
        return this.layoutId;
    }

    public void setLayoutId$ui_release(@NotNull Object obj) {
        this.layoutId = obj;
    }
}
