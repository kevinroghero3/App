package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
final class UnspecifiedConstraintsNode extends Modifier.Node implements LayoutModifierNode {
    private float minHeight;
    private float minWidth;

    public /* synthetic */ UnspecifiedConstraintsNode(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2);
    }

    public /* synthetic */ UnspecifiedConstraintsNode(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.Companion.m3670getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.Companion.m3670getUnspecifiedD9Ej5fM() : f2, null);
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m586getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    /* JADX INFO: renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m588setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m585getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    /* JADX INFO: renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m587setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    private UnspecifiedConstraintsNode(float f, float f2) {
        this.minWidth = f;
        this.minHeight = f2;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo253measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        int iM3605getMinWidthimpl;
        int iM3604getMinHeightimpl;
        float f = this.minWidth;
        Dp.Companion companion = Dp.Companion;
        if (!Dp.m3655equalsimpl0(f, companion.m3670getUnspecifiedD9Ej5fM()) && Constraints.m3605getMinWidthimpl(j) == 0) {
            iM3605getMinWidthimpl = RangesKt___RangesKt.coerceAtLeast(RangesKt___RangesKt.coerceAtMost(measureScope.mo2477roundToPx0680j_4(this.minWidth), Constraints.m3603getMaxWidthimpl(j)), 0);
        } else {
            iM3605getMinWidthimpl = Constraints.m3605getMinWidthimpl(j);
        }
        int iM3603getMaxWidthimpl = Constraints.m3603getMaxWidthimpl(j);
        if (!Dp.m3655equalsimpl0(this.minHeight, companion.m3670getUnspecifiedD9Ej5fM()) && Constraints.m3604getMinHeightimpl(j) == 0) {
            iM3604getMinHeightimpl = RangesKt___RangesKt.coerceAtLeast(RangesKt___RangesKt.coerceAtMost(measureScope.mo2477roundToPx0680j_4(this.minHeight), Constraints.m3602getMaxHeightimpl(j)), 0);
        } else {
            iM3604getMinHeightimpl = Constraints.m3604getMinHeightimpl(j);
        }
        final Placeable placeableMo2525measureBRTryo0 = measurable.mo2525measureBRTryo0(ConstraintsKt.Constraints(iM3605getMinWidthimpl, iM3603getMaxWidthimpl, iM3604getMinHeightimpl, Constraints.m3602getMaxHeightimpl(j)));
        return MeasureScope.layout$default(measureScope, placeableMo2525measureBRTryo0.getWidth(), placeableMo2525measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.UnspecifiedConstraintsNode$measure$1
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

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return RangesKt___RangesKt.coerceAtLeast(intrinsicMeasurable.minIntrinsicWidth(i), !Dp.m3655equalsimpl0(this.minWidth, Dp.Companion.m3670getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo2477roundToPx0680j_4(this.minWidth) : 0);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return RangesKt___RangesKt.coerceAtLeast(intrinsicMeasurable.maxIntrinsicWidth(i), !Dp.m3655equalsimpl0(this.minWidth, Dp.Companion.m3670getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo2477roundToPx0680j_4(this.minWidth) : 0);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return RangesKt___RangesKt.coerceAtLeast(intrinsicMeasurable.minIntrinsicHeight(i), !Dp.m3655equalsimpl0(this.minHeight, Dp.Companion.m3670getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo2477roundToPx0680j_4(this.minHeight) : 0);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return RangesKt___RangesKt.coerceAtLeast(intrinsicMeasurable.maxIntrinsicHeight(i), !Dp.m3655equalsimpl0(this.minHeight, Dp.Companion.m3670getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo2477roundToPx0680j_4(this.minHeight) : 0);
    }
}
