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
final class FocusEventElement extends ModifierNodeElement<FocusEventNode> {
    private final Function1<FocusState, Unit> onFocusEvent;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FocusEventElement copy$default(FocusEventElement focusEventElement, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = focusEventElement.onFocusEvent;
        }
        return focusEventElement.copy(function1);
    }

    public final Function1<FocusState, Unit> component1() {
        return this.onFocusEvent;
    }

    public final FocusEventElement copy(@NotNull Function1<? super FocusState, Unit> function1) {
        return new FocusEventElement(function1);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FocusEventElement) && Intrinsics.areEqual(this.onFocusEvent, ((FocusEventElement) obj).onFocusEvent);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.onFocusEvent.hashCode();
    }

    public String toString() {
        return "FocusEventElement(onFocusEvent=" + this.onFocusEvent + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public final Function1<FocusState, Unit> getOnFocusEvent() {
        return this.onFocusEvent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FocusEventElement(@NotNull Function1<? super FocusState, Unit> function1) {
        this.onFocusEvent = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public FocusEventNode create() {
        return new FocusEventNode(this.onFocusEvent);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(@NotNull FocusEventNode focusEventNode) {
        focusEventNode.setOnFocusEvent(this.onFocusEvent);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        inspectorInfo.setName("onFocusEvent");
        inspectorInfo.getProperties().set("onFocusEvent", this.onFocusEvent);
    }
}
