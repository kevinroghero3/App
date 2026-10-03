package androidx.compose.ui.focus;

import androidx.compose.ui.node.DelegatableNodeKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class FocusPropertiesModifierNodeKt {
    public static final void invalidateFocusProperties(@NotNull FocusPropertiesModifierNode focusPropertiesModifierNode) {
        DelegatableNodeKt.requireOwner(focusPropertiesModifierNode).getFocusOwner().scheduleInvalidation(focusPropertiesModifierNode);
    }
}
