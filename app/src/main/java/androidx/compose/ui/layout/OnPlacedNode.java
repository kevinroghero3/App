package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
final class OnPlacedNode extends Modifier.Node implements LayoutAwareModifierNode {
    private Function1<? super LayoutCoordinates, Unit> callback;

    public final Function1<LayoutCoordinates, Unit> getCallback() {
        return this.callback;
    }

    public final void setCallback(@NotNull Function1<? super LayoutCoordinates, Unit> function1) {
        this.callback = function1;
    }

    public OnPlacedNode(@NotNull Function1<? super LayoutCoordinates, Unit> function1) {
        this.callback = function1;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public void onPlaced(@NotNull LayoutCoordinates layoutCoordinates) {
        this.callback.invoke(layoutCoordinates);
    }
}
