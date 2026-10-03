package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface DrawContext {
    default GraphicsLayer getGraphicsLayer() {
        return null;
    }

    /* JADX INFO: renamed from: getSize-NH-jbRc */
    long mo1648getSizeNHjbRc();

    DrawTransform getTransform();

    default void setCanvas(@NotNull Canvas canvas) {
    }

    default void setDensity(@NotNull Density density) {
    }

    default void setGraphicsLayer(@Nullable GraphicsLayer graphicsLayer) {
    }

    default void setLayoutDirection(@NotNull LayoutDirection layoutDirection) {
    }

    /* JADX INFO: renamed from: setSize-uvyYCjk */
    void mo1649setSizeuvyYCjk(long j);

    default Canvas getCanvas() {
        return new EmptyCanvas();
    }

    default LayoutDirection getLayoutDirection() {
        return LayoutDirection.Ltr;
    }

    default Density getDensity() {
        return DrawContextKt.getDefaultDensity();
    }
}
