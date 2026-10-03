package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.IntSize;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class VerticalRuler extends Ruler {
    public static final int $stable = 0;

    public VerticalRuler() {
        super(null);
    }

    @Override // androidx.compose.ui.layout.Ruler
    public float calculateCoordinate$ui_release(float f, @NotNull LayoutCoordinates layoutCoordinates, @NotNull LayoutCoordinates layoutCoordinates2) {
        return Offset.m928getXimpl(layoutCoordinates2.mo2534localPositionOfR5De75A(layoutCoordinates, OffsetKt.Offset(f, IntSize.m3819getHeightimpl(layoutCoordinates.mo2533getSizeYbymL2g()) / 2.0f)));
    }
}
