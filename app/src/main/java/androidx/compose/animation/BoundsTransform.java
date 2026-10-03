package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.geometry.Rect;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface BoundsTransform {
    FiniteAnimationSpec<Rect> transform(@NotNull Rect rect, @NotNull Rect rect2);
}
