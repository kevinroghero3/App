package androidx.compose.ui.graphics.layer.view;

import android.graphics.Rect;
import android.view.HardwareCanvas;
import android.view.RenderNode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class PlaceholderHardwareCanvas extends HardwareCanvas {
    public int drawRenderNode(@NotNull RenderNode renderNode, @NotNull Rect rect, int i) {
        return 0;
    }

    public boolean isHardwareAccelerated() {
        return true;
    }
}
