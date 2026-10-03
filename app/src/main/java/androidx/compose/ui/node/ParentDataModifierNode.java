package androidx.compose.ui.node;

import androidx.compose.ui.unit.Density;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface ParentDataModifierNode extends DelegatableNode {
    Object modifyParentData(@NotNull Density density, @Nullable Object obj);
}
