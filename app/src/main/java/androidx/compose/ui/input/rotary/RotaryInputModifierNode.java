package androidx.compose.ui.input.rotary;

import androidx.compose.ui.node.DelegatableNode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface RotaryInputModifierNode extends DelegatableNode {
    boolean onPreRotaryScrollEvent(@NotNull RotaryScrollEvent rotaryScrollEvent);

    boolean onRotaryScrollEvent(@NotNull RotaryScrollEvent rotaryScrollEvent);
}
