package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.util.MathHelpersKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ShadowKt {
    public static final Shadow lerp(@NotNull Shadow shadow, @NotNull Shadow shadow2, float f) {
        return new Shadow(ColorKt.m1220lerpjxsXWHM(shadow.m1496getColor0d7_KjU(), shadow2.m1496getColor0d7_KjU(), f), OffsetKt.m951lerpWko1d7g(shadow.m1497getOffsetF1C5BW0(), shadow2.m1497getOffsetF1C5BW0(), f), MathHelpersKt.lerp(shadow.getBlurRadius(), shadow2.getBlurRadius(), f), null);
    }
}
