package androidx.compose.ui.layout;

import androidx.compose.ui.unit.Density;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@MeasureScopeMarker
public interface RulerScope extends Density {
    LayoutCoordinates getCoordinates();

    void provides(@NotNull Ruler ruler, float f);

    void providesRelative(@NotNull VerticalRuler verticalRuler, float f);
}
