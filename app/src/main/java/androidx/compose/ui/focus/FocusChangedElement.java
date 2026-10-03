package androidx.compose.ui.focus;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import ch.qos.logback.core.CoreConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class FocusChangedElement extends ModifierNodeElement<FocusChangedNode> {
    private final Function1<FocusState, Unit> onFocusChanged;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FocusChangedElement copy$default(FocusChangedElement focusChangedElement, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = focusChangedElement.onFocusChanged;
        }
        return focusChangedElement.copy(function1);
    }

    public final Function1<FocusState, Unit> component1() {
        return this.onFocusChanged;
    }

    public final FocusChangedElement copy(@NotNull Function1<? super FocusState, Unit> function1) {
        return new FocusChangedElement(function1);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FocusChangedElement) && Intrinsics.areEqual(this.onFocusChanged, ((FocusChangedElement) obj).onFocusChanged);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.onFocusChanged.hashCode();
    }

    public String toString() {
        return "FocusChangedElement(onFocusChanged=" + this.onFocusChanged + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public final Function1<FocusState, Unit> getOnFocusChanged() {
        return this.onFocusChanged;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FocusChangedElement(@NotNull Function1<? super FocusState, Unit> function1) {
        this.onFocusChanged = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public FocusChangedNode create() {
        return new FocusChangedNode(this.onFocusChanged);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(@NotNull FocusChangedNode focusChangedNode) {
        focusChangedNode.setOnFocusChanged(this.onFocusChanged);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        inspectorInfo.setName("onFocusChanged");
        inspectorInfo.getProperties().set("onFocusChanged", this.onFocusChanged);
    }
}
