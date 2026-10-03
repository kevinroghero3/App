package androidx.compose.ui.node;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class DepthSortedSetsForDifferentPasses {
    public static final int $stable = 8;
    private final DepthSortedSet lookaheadSet;
    private final DepthSortedSet set;

    public DepthSortedSetsForDifferentPasses(boolean z) {
        this.lookaheadSet = new DepthSortedSet(z);
        this.set = new DepthSortedSet(z);
    }

    public final boolean contains(@NotNull LayoutNode layoutNode, boolean z) {
        boolean zContains = this.lookaheadSet.contains(layoutNode);
        if (z) {
            return zContains;
        }
        return zContains || this.set.contains(layoutNode);
    }

    public final boolean contains(@NotNull LayoutNode layoutNode) {
        return this.lookaheadSet.contains(layoutNode) || this.set.contains(layoutNode);
    }

    public final void add(@NotNull LayoutNode layoutNode, boolean z) {
        if (z) {
            this.lookaheadSet.add(layoutNode);
            this.set.add(layoutNode);
        } else {
            if (this.lookaheadSet.contains(layoutNode)) {
                return;
            }
            this.set.add(layoutNode);
        }
    }

    public final boolean remove(@NotNull LayoutNode layoutNode, boolean z) {
        if (z) {
            return this.lookaheadSet.remove(layoutNode);
        }
        return this.set.remove(layoutNode);
    }

    public final boolean remove(@NotNull LayoutNode layoutNode) {
        return this.set.remove(layoutNode) || this.lookaheadSet.remove(layoutNode);
    }

    public final LayoutNode pop() {
        if (!this.lookaheadSet.isEmpty()) {
            return this.lookaheadSet.pop();
        }
        return this.set.pop();
    }

    public final void popEach(@NotNull Function2<? super LayoutNode, ? super Boolean, Unit> function2) {
        while (isNotEmpty()) {
            boolean zIsEmpty = this.lookaheadSet.isEmpty();
            function2.invoke((!zIsEmpty ? this.lookaheadSet : this.set).pop(), Boolean.valueOf(!zIsEmpty));
        }
    }

    public final boolean isEmpty() {
        return this.set.isEmpty() && this.lookaheadSet.isEmpty();
    }

    public final boolean isEmpty(boolean z) {
        return (z ? this.lookaheadSet : this.set).isEmpty();
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }
}
