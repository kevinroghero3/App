package androidx.compose.animation;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface LayerRenderer {
    void drawInOverlay(@NotNull DrawScope drawScope);

    SharedElementInternalState getParentState();

    float getZIndex();
}
