package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
final class FocusEventNode extends Modifier.Node implements FocusEventModifierNode {
    private Function1<? super FocusState, Unit> onFocusEvent;

    public final Function1<FocusState, Unit> getOnFocusEvent() {
        return this.onFocusEvent;
    }

    public final void setOnFocusEvent(@NotNull Function1<? super FocusState, Unit> function1) {
        this.onFocusEvent = function1;
    }

    public FocusEventNode(@NotNull Function1<? super FocusState, Unit> function1) {
        this.onFocusEvent = function1;
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public void onFocusEvent(@NotNull FocusState focusState) {
        this.onFocusEvent.invoke(focusState);
    }
}
