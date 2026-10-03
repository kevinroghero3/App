package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
final class FillNode extends Modifier.Node implements LayoutModifierNode {
    private Direction direction;
    private float fraction;

    public final Direction getDirection() {
        return this.direction;
    }

    public final void setDirection(@NotNull Direction direction) {
        this.direction = direction;
    }

    public final float getFraction() {
        return this.fraction;
    }

    public final void setFraction(float f) {
        this.fraction = f;
    }

    public FillNode(@NotNull Direction direction, float f) {
        this.direction = direction;
        this.fraction = f;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo253measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        int iM3605getMinWidthimpl;
        int iM3603getMaxWidthimpl;
        int iM3602getMaxHeightimpl;
        int iCoerceIn;
        if (Constraints.m3599getHasBoundedWidthimpl(j) && this.direction != Direction.Vertical) {
            iM3605getMinWidthimpl = RangesKt___RangesKt.coerceIn(Math.round(Constraints.m3603getMaxWidthimpl(j) * this.fraction), Constraints.m3605getMinWidthimpl(j), Constraints.m3603getMaxWidthimpl(j));
            iM3603getMaxWidthimpl = iM3605getMinWidthimpl;
        } else {
            iM3605getMinWidthimpl = Constraints.m3605getMinWidthimpl(j);
            iM3603getMaxWidthimpl = Constraints.m3603getMaxWidthimpl(j);
        }
        if (Constraints.m3598getHasBoundedHeightimpl(j) && this.direction != Direction.Horizontal) {
            iCoerceIn = RangesKt___RangesKt.coerceIn(Math.round(Constraints.m3602getMaxHeightimpl(j) * this.fraction), Constraints.m3604getMinHeightimpl(j), Constraints.m3602getMaxHeightimpl(j));
            iM3602getMaxHeightimpl = iCoerceIn;
        } else {
            int iM3604getMinHeightimpl = Constraints.m3604getMinHeightimpl(j);
            iM3602getMaxHeightimpl = Constraints.m3602getMaxHeightimpl(j);
            iCoerceIn = iM3604getMinHeightimpl;
        }
        final Placeable placeableMo2525measureBRTryo0 = measurable.mo2525measureBRTryo0(ConstraintsKt.Constraints(iM3605getMinWidthimpl, iM3603getMaxWidthimpl, iCoerceIn, iM3602getMaxHeightimpl));
        return MeasureScope.layout$default(measureScope, placeableMo2525measureBRTryo0.getWidth(), placeableMo2525measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FillNode$measure$1
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
                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo2525measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
