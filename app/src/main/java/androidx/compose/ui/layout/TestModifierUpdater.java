package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "It is a test API, do not use it in the real applications")
public final class TestModifierUpdater {
    public static final int $stable = 8;
    private final LayoutNode node;

    public TestModifierUpdater(@NotNull LayoutNode layoutNode) {
        this.node = layoutNode;
    }

    public final void updateModifier(@NotNull Modifier modifier) {
        this.node.setModifier(modifier);
    }
}
