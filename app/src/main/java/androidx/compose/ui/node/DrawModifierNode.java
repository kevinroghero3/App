package androidx.compose.ui.node;

import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface DrawModifierNode extends DelegatableNode {
    void draw(@NotNull ContentDrawScope contentDrawScope);

    default void onMeasureResultChanged() {
    }
}
