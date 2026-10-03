package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;

/* JADX INFO: loaded from: classes4.dex */
public final class DrawContextKt {
    private static final Density DefaultDensity = DensityKt.Density(1.0f, 1.0f);

    public static final Density getDefaultDensity() {
        return DefaultDensity;
    }
}
