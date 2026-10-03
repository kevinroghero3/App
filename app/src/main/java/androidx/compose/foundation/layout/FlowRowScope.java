package androidx.compose.foundation.layout;

import androidx.annotation.FloatRange;
import androidx.compose.ui.Modifier;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@LayoutScopeMarker
public interface FlowRowScope extends RowScope {
    Modifier fillMaxRowHeight(@NotNull Modifier modifier, @FloatRange(from = 0.0d, to = 1.0d) float f);

    static /* synthetic */ Modifier fillMaxRowHeight$default(FlowRowScope flowRowScope, Modifier modifier, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillMaxRowHeight");
        }
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return flowRowScope.fillMaxRowHeight(modifier, f);
    }
}
