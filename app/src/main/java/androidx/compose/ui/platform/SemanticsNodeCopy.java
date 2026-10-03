package androidx.compose.ui.platform;

import androidx.collection.IntObjectMap;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntSet;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNode;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class SemanticsNodeCopy {
    public static final int $stable = 8;
    private final MutableIntSet children = IntSetKt.mutableIntSetOf();
    private final SemanticsConfiguration unmergedConfig;

    public SemanticsNodeCopy(@NotNull SemanticsNode semanticsNode, @NotNull IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap) {
        this.unmergedConfig = semanticsNode.getUnmergedConfig$ui_release();
        List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i = 0; i < size; i++) {
            SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i);
            if (intObjectMap.contains(semanticsNode2.getId())) {
                this.children.add(semanticsNode2.getId());
            }
        }
    }

    public final SemanticsConfiguration getUnmergedConfig() {
        return this.unmergedConfig;
    }

    public final MutableIntSet getChildren() {
        return this.children;
    }
}
