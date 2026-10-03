package androidx.compose.animation;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.ContentScale;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
final class ScaleToBoundsImpl implements SharedTransitionScope.ResizeMode {
    private final Alignment alignment;
    private final ContentScale contentScale;

    public ScaleToBoundsImpl(@NotNull ContentScale contentScale, @NotNull Alignment alignment) {
        this.contentScale = contentScale;
        this.alignment = alignment;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }
}
