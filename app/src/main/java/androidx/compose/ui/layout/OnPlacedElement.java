package androidx.compose.ui.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import ch.qos.logback.core.CoreConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class OnPlacedElement extends ModifierNodeElement<OnPlacedNode> {
    private final Function1<LayoutCoordinates, Unit> onPlaced;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OnPlacedElement copy$default(OnPlacedElement onPlacedElement, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = onPlacedElement.onPlaced;
        }
        return onPlacedElement.copy(function1);
    }

    public final Function1<LayoutCoordinates, Unit> component1() {
        return this.onPlaced;
    }

    public final OnPlacedElement copy(@NotNull Function1<? super LayoutCoordinates, Unit> function1) {
        return new OnPlacedElement(function1);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OnPlacedElement) && Intrinsics.areEqual(this.onPlaced, ((OnPlacedElement) obj).onPlaced);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.onPlaced.hashCode();
    }

    public String toString() {
        return "OnPlacedElement(onPlaced=" + this.onPlaced + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public final Function1<LayoutCoordinates, Unit> getOnPlaced() {
        return this.onPlaced;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OnPlacedElement(@NotNull Function1<? super LayoutCoordinates, Unit> function1) {
        this.onPlaced = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public OnPlacedNode create() {
        return new OnPlacedNode(this.onPlaced);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(@NotNull OnPlacedNode onPlacedNode) {
        onPlacedNode.setCallback(this.onPlaced);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        inspectorInfo.setName("onPlaced");
        inspectorInfo.getProperties().set("onPlaced", this.onPlaced);
    }
}
