package androidx.compose.ui.graphics.layer;

import android.view.RenderNode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
final class RenderNodeVerificationHelper28 {
    public static final RenderNodeVerificationHelper28 INSTANCE = new RenderNodeVerificationHelper28();

    private RenderNodeVerificationHelper28() {
    }

    public final int getAmbientShadowColor(@NotNull RenderNode renderNode) {
        return renderNode.getAmbientShadowColor();
    }

    public final void setAmbientShadowColor(@NotNull RenderNode renderNode, int i) {
        renderNode.setAmbientShadowColor(i);
    }

    public final int getSpotShadowColor(@NotNull RenderNode renderNode) {
        return renderNode.getSpotShadowColor();
    }

    public final void setSpotShadowColor(@NotNull RenderNode renderNode, int i) {
        renderNode.setSpotShadowColor(i);
    }
}
