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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
final class SizeNode extends Modifier.Node implements LayoutModifierNode {
    private boolean enforceIncoming;
    private float maxHeight;
    private float maxWidth;
    private float minHeight;
    private float minWidth;

    public /* synthetic */ SizeNode(float f, float f2, float f3, float f4, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z);
    }

    public /* synthetic */ SizeNode(float f, float f2, float f3, float f4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.Companion.m3670getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.Companion.m3670getUnspecifiedD9Ej5fM() : f2, (i & 4) != 0 ? Dp.Companion.m3670getUnspecifiedD9Ej5fM() : f3, (i & 8) != 0 ? Dp.Companion.m3670getUnspecifiedD9Ej5fM() : f4, z, null);
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m578getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    /* JADX INFO: renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m582setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m577getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    /* JADX INFO: renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m581setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    /* JADX INFO: renamed from: getMaxWidth-D9Ej5fM, reason: not valid java name */
    public final float m576getMaxWidthD9Ej5fM() {
        return this.maxWidth;
    }

    /* JADX INFO: renamed from: setMaxWidth-0680j_4, reason: not valid java name */
    public final void m580setMaxWidth0680j_4(float f) {
        this.maxWidth = f;
    }

    /* JADX INFO: renamed from: getMaxHeight-D9Ej5fM, reason: not valid java name */
    public final float m575getMaxHeightD9Ej5fM() {
        return this.maxHeight;
    }

    /* JADX INFO: renamed from: setMaxHeight-0680j_4, reason: not valid java name */
    public final void m579setMaxHeight0680j_4(float f) {
        this.maxHeight = f;
    }

    public final boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    public final void setEnforceIncoming(boolean z) {
        this.enforceIncoming = z;
    }

    private SizeNode(float f, float f2, float f3, float f4, boolean z) {
        this.minWidth = f;
        this.minHeight = f2;
        this.maxWidth = f3;
        this.maxHeight = f4;
        this.enforceIncoming = z;
    }

    /* JADX INFO: renamed from: getTargetConstraints-OenEA2s, reason: not valid java name */
    private final long m574getTargetConstraintsOenEA2s(Density density) {
        int iCoerceAtLeast;
        int iCoerceAtLeast2;
        float f = this.maxWidth;
        Dp.Companion companion = Dp.Companion;
        int i = 0;
        int iCoerceAtLeast3 = !Dp.m3655equalsimpl0(f, companion.m3670getUnspecifiedD9Ej5fM()) ? RangesKt___RangesKt.coerceAtLeast(density.mo2477roundToPx0680j_4(this.maxWidth), 0) : Integer.MAX_VALUE;
        int iCoerceAtLeast4 = !Dp.m3655equalsimpl0(this.maxHeight, companion.m3670getUnspecifiedD9Ej5fM()) ? RangesKt___RangesKt.coerceAtLeast(density.mo2477roundToPx0680j_4(this.maxHeight), 0) : Integer.MAX_VALUE;
        if (Dp.m3655equalsimpl0(this.minWidth, companion.m3670getUnspecifiedD9Ej5fM()) || (iCoerceAtLeast = RangesKt___RangesKt.coerceAtLeast(RangesKt___RangesKt.coerceAtMost(density.mo2477roundToPx0680j_4(this.minWidth), iCoerceAtLeast3), 0)) == Integer.MAX_VALUE) {
            iCoerceAtLeast = 0;
        }
        if (!Dp.m3655equalsimpl0(this.minHeight, companion.m3670getUnspecifiedD9Ej5fM()) && (iCoerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(RangesKt___RangesKt.coerceAtMost(density.mo2477roundToPx0680j_4(this.minHeight), iCoerceAtLeast4), 0)) != Integer.MAX_VALUE) {
            i = iCoerceAtLeast2;
        }
        return ConstraintsKt.Constraints(iCoerceAtLeast, iCoerceAtLeast3, i, iCoerceAtLeast4);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo253measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        int iCoerceAtMost;
        int iCoerceAtLeast;
        int iCoerceAtMost2;
        int iCoerceAtLeast2;
        long jConstraints;
        long jM574getTargetConstraintsOenEA2s = m574getTargetConstraintsOenEA2s(measureScope);
        if (this.enforceIncoming) {
            jConstraints = ConstraintsKt.m3618constrainN9IONVI(j, jM574getTargetConstraintsOenEA2s);
        } else {
            float f = this.minWidth;
            Dp.Companion companion = Dp.Companion;
            if (!Dp.m3655equalsimpl0(f, companion.m3670getUnspecifiedD9Ej5fM())) {
                iCoerceAtMost = Constraints.m3605getMinWidthimpl(jM574getTargetConstraintsOenEA2s);
            } else {
                iCoerceAtMost = RangesKt___RangesKt.coerceAtMost(Constraints.m3605getMinWidthimpl(j), Constraints.m3603getMaxWidthimpl(jM574getTargetConstraintsOenEA2s));
            }
            if (!Dp.m3655equalsimpl0(this.maxWidth, companion.m3670getUnspecifiedD9Ej5fM())) {
                iCoerceAtLeast = Constraints.m3603getMaxWidthimpl(jM574getTargetConstraintsOenEA2s);
            } else {
                iCoerceAtLeast = RangesKt___RangesKt.coerceAtLeast(Constraints.m3603getMaxWidthimpl(j), Constraints.m3605getMinWidthimpl(jM574getTargetConstraintsOenEA2s));
            }
            if (!Dp.m3655equalsimpl0(this.minHeight, companion.m3670getUnspecifiedD9Ej5fM())) {
                iCoerceAtMost2 = Constraints.m3604getMinHeightimpl(jM574getTargetConstraintsOenEA2s);
            } else {
                iCoerceAtMost2 = RangesKt___RangesKt.coerceAtMost(Constraints.m3604getMinHeightimpl(j), Constraints.m3602getMaxHeightimpl(jM574getTargetConstraintsOenEA2s));
            }
            if (!Dp.m3655equalsimpl0(this.maxHeight, companion.m3670getUnspecifiedD9Ej5fM())) {
                iCoerceAtLeast2 = Constraints.m3602getMaxHeightimpl(jM574getTargetConstraintsOenEA2s);
            } else {
                iCoerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(Constraints.m3602getMaxHeightimpl(j), Constraints.m3604getMinHeightimpl(jM574getTargetConstraintsOenEA2s));
            }
            jConstraints = ConstraintsKt.Constraints(iCoerceAtMost, iCoerceAtLeast, iCoerceAtMost2, iCoerceAtLeast2);
        }
        final Placeable placeableMo2525measureBRTryo0 = measurable.mo2525measureBRTryo0(jConstraints);
        return MeasureScope.layout$default(measureScope, placeableMo2525measureBRTryo0.getWidth(), placeableMo2525measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.SizeNode$measure$1
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
        long jM574getTargetConstraintsOenEA2s = m574getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m3601getHasFixedWidthimpl(jM574getTargetConstraintsOenEA2s)) {
            return Constraints.m3603getMaxWidthimpl(jM574getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m3620constrainWidthK40F9xA(jM574getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM574getTargetConstraintsOenEA2s = m574getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m3600getHasFixedHeightimpl(jM574getTargetConstraintsOenEA2s)) {
            return Constraints.m3602getMaxHeightimpl(jM574getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m3619constrainHeightK40F9xA(jM574getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM574getTargetConstraintsOenEA2s = m574getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m3601getHasFixedWidthimpl(jM574getTargetConstraintsOenEA2s)) {
            return Constraints.m3603getMaxWidthimpl(jM574getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m3620constrainWidthK40F9xA(jM574getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM574getTargetConstraintsOenEA2s = m574getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m3600getHasFixedHeightimpl(jM574getTargetConstraintsOenEA2s)) {
            return Constraints.m3602getMaxHeightimpl(jM574getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m3619constrainHeightK40F9xA(jM574getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicHeight(i));
    }
}
