package androidx.compose.ui.node;

import androidx.compose.ui.layout.LayoutCoordinates;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface GlobalPositionAwareModifierNode extends DelegatableNode {
    void onGloballyPositioned(@NotNull LayoutCoordinates layoutCoordinates);
}
