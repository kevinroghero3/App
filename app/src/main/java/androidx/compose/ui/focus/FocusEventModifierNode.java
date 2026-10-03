package androidx.compose.ui.focus;

import androidx.compose.ui.node.DelegatableNode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface FocusEventModifierNode extends DelegatableNode {
    void onFocusEvent(@NotNull FocusState focusState);
}
