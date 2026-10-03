package androidx.compose.ui.node;

import androidx.compose.ui.layout.LayoutCoordinates;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface LayoutAwareModifierNode extends DelegatableNode {
    default void onPlaced(@NotNull LayoutCoordinates layoutCoordinates) {
    }

    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    default void mo2580onRemeasuredozmzZPI(long j) {
    }
}
