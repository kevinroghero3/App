package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface LookaheadScope {
    LayoutCoordinates getLookaheadScopeCoordinates(@NotNull Placeable.PlacementScope placementScope);

    LayoutCoordinates toLookaheadCoordinates(@NotNull LayoutCoordinates layoutCoordinates);

    /* JADX INFO: renamed from: localLookaheadPositionOf-au-aQtc$default, reason: not valid java name */
    static /* synthetic */ long m2553localLookaheadPositionOfauaQtc$default(LookaheadScope lookaheadScope, LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, long j, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localLookaheadPositionOf-au-aQtc");
        }
        if ((i & 2) != 0) {
            j = Offset.Companion.m944getZeroF1C5BW0();
        }
        long j2 = j;
        if ((i & 4) != 0) {
            z = true;
        }
        return lookaheadScope.mo271localLookaheadPositionOfauaQtc(layoutCoordinates, layoutCoordinates2, j2, z);
    }

    /* JADX INFO: renamed from: localLookaheadPositionOf-au-aQtc */
    default long mo271localLookaheadPositionOfauaQtc(@NotNull LayoutCoordinates layoutCoordinates, @NotNull LayoutCoordinates layoutCoordinates2, long j, boolean z) {
        return LookaheadScopeKt.m2554localLookaheadPositionOfFgt4K4Q(this, layoutCoordinates, layoutCoordinates2, j, z);
    }
}
