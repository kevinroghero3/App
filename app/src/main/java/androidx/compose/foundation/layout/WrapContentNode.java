package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
final class WrapContentNode extends Modifier.Node implements LayoutModifierNode {
    private Function2<? super IntSize, ? super LayoutDirection, IntOffset> alignmentCallback;
    private Direction direction;
    private boolean unbounded;

    public final Direction getDirection() {
        return this.direction;
    }

    public final void setDirection(@NotNull Direction direction) {
        this.direction = direction;
    }

    public final boolean getUnbounded() {
        return this.unbounded;
    }

    public final void setUnbounded(boolean z) {
        this.unbounded = z;
    }

    public final Function2<IntSize, LayoutDirection, IntOffset> getAlignmentCallback() {
        return this.alignmentCallback;
    }

    public final void setAlignmentCallback(@NotNull Function2<? super IntSize, ? super LayoutDirection, IntOffset> function2) {
        this.alignmentCallback = function2;
    }

    public WrapContentNode(@NotNull Direction direction, boolean z, @NotNull Function2<? super IntSize, ? super LayoutDirection, IntOffset> function2) {
        this.direction = direction;
        this.unbounded = z;
        this.alignmentCallback = function2;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo253measure3p2s80s(@NotNull final MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Direction direction = this.direction;
        Direction direction2 = Direction.Vertical;
        int iM3605getMinWidthimpl = direction != direction2 ? 0 : Constraints.m3605getMinWidthimpl(j);
        Direction direction3 = this.direction;
        Direction direction4 = Direction.Horizontal;
        final Placeable placeableMo2525measureBRTryo0 = measurable.mo2525measureBRTryo0(ConstraintsKt.Constraints(iM3605getMinWidthimpl, (this.direction == direction2 || !this.unbounded) ? Constraints.m3603getMaxWidthimpl(j) : Integer.MAX_VALUE, direction3 == direction4 ? Constraints.m3604getMinHeightimpl(j) : 0, (this.direction == direction4 || !this.unbounded) ? Constraints.m3602getMaxHeightimpl(j) : Integer.MAX_VALUE));
        final int iCoerceIn = RangesKt___RangesKt.coerceIn(placeableMo2525measureBRTryo0.getWidth(), Constraints.m3605getMinWidthimpl(j), Constraints.m3603getMaxWidthimpl(j));
        final int iCoerceIn2 = RangesKt___RangesKt.coerceIn(placeableMo2525measureBRTryo0.getHeight(), Constraints.m3604getMinHeightimpl(j), Constraints.m3602getMaxHeightimpl(j));
        return MeasureScope.layout$default(measureScope, iCoerceIn, iCoerceIn2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.WrapContentNode$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.m2590place70tqf50$default(placementScope, placeableMo2525measureBRTryo0, this.this$0.getAlignmentCallback().invoke(IntSize.m3812boximpl(IntSizeKt.IntSize(iCoerceIn - placeableMo2525measureBRTryo0.getWidth(), iCoerceIn2 - placeableMo2525measureBRTryo0.getHeight())), measureScope.getLayoutDirection()).m3787unboximpl(), 0.0f, 2, null);
            }
        }, 4, null);
    }
}
