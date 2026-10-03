package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@LayoutScopeMarker
public interface BoxScope {
    Modifier align(@NotNull Modifier modifier, @NotNull Alignment alignment);

    Modifier matchParentSize(@NotNull Modifier modifier);
}
