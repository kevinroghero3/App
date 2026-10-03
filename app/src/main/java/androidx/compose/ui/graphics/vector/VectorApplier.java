package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.AbstractApplier;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class VectorApplier extends AbstractApplier<VNode> {
    public static final int $stable = 0;

    @Override // androidx.compose.runtime.Applier
    public void insertTopDown(int i, @NotNull VNode vNode) {
    }

    public VectorApplier(@NotNull VNode vNode) {
        super(vNode);
    }

    @Override // androidx.compose.runtime.Applier
    public void insertBottomUp(int i, @NotNull VNode vNode) {
        asGroup(getCurrent()).insertAt(i, vNode);
    }

    @Override // androidx.compose.runtime.Applier
    public void remove(int i, int i2) {
        asGroup(getCurrent()).remove(i, i2);
    }

    @Override // androidx.compose.runtime.AbstractApplier
    public void onClear() {
        GroupComponent groupComponentAsGroup = asGroup(getRoot());
        groupComponentAsGroup.remove(0, groupComponentAsGroup.getNumChildren());
    }

    @Override // androidx.compose.runtime.Applier
    public void move(int i, int i2, int i3) {
        asGroup(getCurrent()).move(i, i2, i3);
    }

    private final GroupComponent asGroup(VNode vNode) {
        if (vNode instanceof GroupComponent) {
            return (GroupComponent) vNode;
        }
        throw new IllegalStateException("Cannot only insert VNode into Group");
    }
}
