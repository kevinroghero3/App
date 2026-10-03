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
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {
    private float aspectRatio;
    private boolean matchHeightConstraintsFirst;

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final void setAspectRatio(float f) {
        this.aspectRatio = f;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    public final void setMatchHeightConstraintsFirst(boolean z) {
        this.matchHeightConstraintsFirst = z;
    }

    public AspectRatioNode(float f, boolean z) {
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo253measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        long jM418findSizeToXhtMw = m418findSizeToXhtMw(j);
        if (!IntSize.m3818equalsimpl0(jM418findSizeToXhtMw, IntSize.Companion.m3825getZeroYbymL2g())) {
            j = Constraints.Companion.m3613fixedJhjzzOo(IntSize.m3820getWidthimpl(jM418findSizeToXhtMw), IntSize.m3819getHeightimpl(jM418findSizeToXhtMw));
        }
        final Placeable placeableMo2525measureBRTryo0 = measurable.mo2525measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeableMo2525measureBRTryo0.getWidth(), placeableMo2525measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AspectRatioNode$measure$1
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
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        return Math.round(i * this.aspectRatio);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }
        return Math.round(i * this.aspectRatio);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        return Math.round(i / this.aspectRatio);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
        return Math.round(i / this.aspectRatio);
    }

    /* JADX INFO: renamed from: findSize-ToXhtMw, reason: not valid java name */
    private final long m418findSizeToXhtMw(long j) {
        if (!this.matchHeightConstraintsFirst) {
            long jM422tryMaxWidthJN0ABg$default = m422tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            IntSize.Companion companion = IntSize.Companion;
            if (!IntSize.m3818equalsimpl0(jM422tryMaxWidthJN0ABg$default, companion.m3825getZeroYbymL2g())) {
                return jM422tryMaxWidthJN0ABg$default;
            }
            long jM420tryMaxHeightJN0ABg$default = m420tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m3818equalsimpl0(jM420tryMaxHeightJN0ABg$default, companion.m3825getZeroYbymL2g())) {
                return jM420tryMaxHeightJN0ABg$default;
            }
            long jM426tryMinWidthJN0ABg$default = m426tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m3818equalsimpl0(jM426tryMinWidthJN0ABg$default, companion.m3825getZeroYbymL2g())) {
                return jM426tryMinWidthJN0ABg$default;
            }
            long jM424tryMinHeightJN0ABg$default = m424tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m3818equalsimpl0(jM424tryMinHeightJN0ABg$default, companion.m3825getZeroYbymL2g())) {
                return jM424tryMinHeightJN0ABg$default;
            }
            long jM421tryMaxWidthJN0ABg = m421tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m3818equalsimpl0(jM421tryMaxWidthJN0ABg, companion.m3825getZeroYbymL2g())) {
                return jM421tryMaxWidthJN0ABg;
            }
            long jM419tryMaxHeightJN0ABg = m419tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m3818equalsimpl0(jM419tryMaxHeightJN0ABg, companion.m3825getZeroYbymL2g())) {
                return jM419tryMaxHeightJN0ABg;
            }
            long jM425tryMinWidthJN0ABg = m425tryMinWidthJN0ABg(j, false);
            if (!IntSize.m3818equalsimpl0(jM425tryMinWidthJN0ABg, companion.m3825getZeroYbymL2g())) {
                return jM425tryMinWidthJN0ABg;
            }
            long jM423tryMinHeightJN0ABg = m423tryMinHeightJN0ABg(j, false);
            if (!IntSize.m3818equalsimpl0(jM423tryMinHeightJN0ABg, companion.m3825getZeroYbymL2g())) {
                return jM423tryMinHeightJN0ABg;
            }
        } else {
            long jM420tryMaxHeightJN0ABg$default2 = m420tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            IntSize.Companion companion2 = IntSize.Companion;
            if (!IntSize.m3818equalsimpl0(jM420tryMaxHeightJN0ABg$default2, companion2.m3825getZeroYbymL2g())) {
                return jM420tryMaxHeightJN0ABg$default2;
            }
            long jM422tryMaxWidthJN0ABg$default2 = m422tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m3818equalsimpl0(jM422tryMaxWidthJN0ABg$default2, companion2.m3825getZeroYbymL2g())) {
                return jM422tryMaxWidthJN0ABg$default2;
            }
            long jM424tryMinHeightJN0ABg$default2 = m424tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m3818equalsimpl0(jM424tryMinHeightJN0ABg$default2, companion2.m3825getZeroYbymL2g())) {
                return jM424tryMinHeightJN0ABg$default2;
            }
            long jM426tryMinWidthJN0ABg$default2 = m426tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m3818equalsimpl0(jM426tryMinWidthJN0ABg$default2, companion2.m3825getZeroYbymL2g())) {
                return jM426tryMinWidthJN0ABg$default2;
            }
            long jM419tryMaxHeightJN0ABg2 = m419tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m3818equalsimpl0(jM419tryMaxHeightJN0ABg2, companion2.m3825getZeroYbymL2g())) {
                return jM419tryMaxHeightJN0ABg2;
            }
            long jM421tryMaxWidthJN0ABg2 = m421tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m3818equalsimpl0(jM421tryMaxWidthJN0ABg2, companion2.m3825getZeroYbymL2g())) {
                return jM421tryMaxWidthJN0ABg2;
            }
            long jM423tryMinHeightJN0ABg2 = m423tryMinHeightJN0ABg(j, false);
            if (!IntSize.m3818equalsimpl0(jM423tryMinHeightJN0ABg2, companion2.m3825getZeroYbymL2g())) {
                return jM423tryMinHeightJN0ABg2;
            }
            long jM425tryMinWidthJN0ABg2 = m425tryMinWidthJN0ABg(j, false);
            if (!IntSize.m3818equalsimpl0(jM425tryMinWidthJN0ABg2, companion2.m3825getZeroYbymL2g())) {
                return jM425tryMinWidthJN0ABg2;
            }
        }
        return IntSize.Companion.m3825getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMaxWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m422tryMaxWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m421tryMaxWidthJN0ABg(j, z);
    }

    /* JADX INFO: renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    private final long m421tryMaxWidthJN0ABg(long j, boolean z) {
        int iRound;
        int iM3603getMaxWidthimpl = Constraints.m3603getMaxWidthimpl(j);
        if (iM3603getMaxWidthimpl != Integer.MAX_VALUE && (iRound = Math.round(iM3603getMaxWidthimpl / this.aspectRatio)) > 0) {
            long jIntSize = IntSizeKt.IntSize(iM3603getMaxWidthimpl, iRound);
            if (!z || ConstraintsKt.m3621isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.Companion.m3825getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMaxHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m420tryMaxHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m419tryMaxHeightJN0ABg(j, z);
    }

    /* JADX INFO: renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    private final long m419tryMaxHeightJN0ABg(long j, boolean z) {
        int iRound;
        int iM3602getMaxHeightimpl = Constraints.m3602getMaxHeightimpl(j);
        if (iM3602getMaxHeightimpl != Integer.MAX_VALUE && (iRound = Math.round(iM3602getMaxHeightimpl * this.aspectRatio)) > 0) {
            long jIntSize = IntSizeKt.IntSize(iRound, iM3602getMaxHeightimpl);
            if (!z || ConstraintsKt.m3621isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.Companion.m3825getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMinWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m426tryMinWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m425tryMinWidthJN0ABg(j, z);
    }

    /* JADX INFO: renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    private final long m425tryMinWidthJN0ABg(long j, boolean z) {
        int iM3605getMinWidthimpl = Constraints.m3605getMinWidthimpl(j);
        int iRound = Math.round(iM3605getMinWidthimpl / this.aspectRatio);
        if (iRound > 0) {
            long jIntSize = IntSizeKt.IntSize(iM3605getMinWidthimpl, iRound);
            if (!z || ConstraintsKt.m3621isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.Companion.m3825getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMinHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m424tryMinHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m423tryMinHeightJN0ABg(j, z);
    }

    /* JADX INFO: renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    private final long m423tryMinHeightJN0ABg(long j, boolean z) {
        int iM3604getMinHeightimpl = Constraints.m3604getMinHeightimpl(j);
        int iRound = Math.round(iM3604getMinHeightimpl * this.aspectRatio);
        if (iRound > 0) {
            long jIntSize = IntSizeKt.IntSize(iRound, iM3604getMinHeightimpl);
            if (!z || ConstraintsKt.m3621isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.Companion.m3825getZeroYbymL2g();
    }
}
