package androidx.compose.ui.node;

import androidx.compose.ui.layout.MeasureResult;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class PlaceableResult implements OwnerScope {
    private final LookaheadCapablePlaceable placeable;
    private final MeasureResult result;

    public static /* synthetic */ PlaceableResult copy$default(PlaceableResult placeableResult, MeasureResult measureResult, LookaheadCapablePlaceable lookaheadCapablePlaceable, int i, Object obj) {
        if ((i & 1) != 0) {
            measureResult = placeableResult.result;
        }
        if ((i & 2) != 0) {
            lookaheadCapablePlaceable = placeableResult.placeable;
        }
        return placeableResult.copy(measureResult, lookaheadCapablePlaceable);
    }

    public final MeasureResult component1() {
        return this.result;
    }

    public final LookaheadCapablePlaceable component2() {
        return this.placeable;
    }

    public final PlaceableResult copy(@NotNull MeasureResult measureResult, @NotNull LookaheadCapablePlaceable lookaheadCapablePlaceable) {
        return new PlaceableResult(measureResult, lookaheadCapablePlaceable);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceableResult)) {
            return false;
        }
        PlaceableResult placeableResult = (PlaceableResult) obj;
        return Intrinsics.areEqual(this.result, placeableResult.result) && Intrinsics.areEqual(this.placeable, placeableResult.placeable);
    }

    public int hashCode() {
        return (this.result.hashCode() * 31) + this.placeable.hashCode();
    }

    public String toString() {
        return "PlaceableResult(result=" + this.result + ", placeable=" + this.placeable + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public PlaceableResult(@NotNull MeasureResult measureResult, @NotNull LookaheadCapablePlaceable lookaheadCapablePlaceable) {
        this.result = measureResult;
        this.placeable = lookaheadCapablePlaceable;
    }

    public final MeasureResult getResult() {
        return this.result;
    }

    public final LookaheadCapablePlaceable getPlaceable() {
        return this.placeable;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return this.placeable.getCoordinates().isAttached();
    }
}
