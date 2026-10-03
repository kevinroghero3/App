package androidx.compose.ui.node;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface OwnedLayer {
    void destroy();

    void drawLayer(@NotNull Canvas canvas, @Nullable GraphicsLayer graphicsLayer);

    void invalidate();

    /* JADX INFO: renamed from: inverseTransform-58bKbWc, reason: not valid java name */
    void mo2808inverseTransform58bKbWc(@NotNull float[] fArr);

    /* JADX INFO: renamed from: isInLayer-k-4lQ0M, reason: not valid java name */
    boolean mo2809isInLayerk4lQ0M(long j);

    void mapBounds(@NotNull MutableRect mutableRect, boolean z);

    /* JADX INFO: renamed from: mapOffset-8S9VItk, reason: not valid java name */
    long mo2810mapOffset8S9VItk(long j, boolean z);

    /* JADX INFO: renamed from: move--gyyYBs, reason: not valid java name */
    void mo2811movegyyYBs(long j);

    /* JADX INFO: renamed from: resize-ozmzZPI, reason: not valid java name */
    void mo2812resizeozmzZPI(long j);

    void reuseLayer(@NotNull Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, @NotNull Function0<Unit> function0);

    /* JADX INFO: renamed from: transform-58bKbWc, reason: not valid java name */
    void mo2813transform58bKbWc(@NotNull float[] fArr);

    void updateDisplayList();

    void updateLayerProperties(@NotNull ReusableGraphicsLayerScope reusableGraphicsLayerScope);
}
