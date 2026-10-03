package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import ch.qos.logback.core.CoreConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class PainterNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;
    private boolean sizeToIntrinsics;

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final Painter getPainter() {
        return this.painter;
    }

    public final void setPainter(@NotNull Painter painter) {
        this.painter = painter;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    public final void setSizeToIntrinsics(boolean z) {
        this.sizeToIntrinsics = z;
    }

    public /* synthetic */ PainterNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, z, (i & 4) != 0 ? Alignment.Companion.getCenter() : alignment, (i & 8) != 0 ? ContentScale.Companion.getInside() : contentScale, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? null : colorFilter);
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final void setAlignment(@NotNull Alignment alignment) {
        this.alignment = alignment;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final void setContentScale(@NotNull ContentScale contentScale) {
        this.contentScale = contentScale;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public PainterNode(@NotNull Painter painter, boolean z, @NotNull Alignment alignment, @NotNull ContentScale contentScale, float f, @Nullable ColorFilter colorFilter) {
        this.painter = painter;
        this.sizeToIntrinsics = z;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    private final boolean getUseIntrinsicSize() {
        return this.sizeToIntrinsics && this.painter.mo1848getIntrinsicSizeNHjbRc() != InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo253measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        final Placeable placeableMo2525measureBRTryo0 = measurable.mo2525measureBRTryo0(m823modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measureScope, placeableMo2525measureBRTryo0.getWidth(), placeableMo2525measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.draw.PainterNode$measure$1
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
        if (getUseIntrinsicSize()) {
            long jM823modifyConstraintsZezNO4M = m823modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
            return Math.max(Constraints.m3605getMinWidthimpl(jM823modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicWidth(i));
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (getUseIntrinsicSize()) {
            long jM823modifyConstraintsZezNO4M = m823modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
            return Math.max(Constraints.m3605getMinWidthimpl(jM823modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicWidth(i));
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (getUseIntrinsicSize()) {
            long jM823modifyConstraintsZezNO4M = m823modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
            return Math.max(Constraints.m3604getMinHeightimpl(jM823modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicHeight(i));
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (getUseIntrinsicSize()) {
            long jM823modifyConstraintsZezNO4M = m823modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
            return Math.max(Constraints.m3604getMinHeightimpl(jM823modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicHeight(i));
        }
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    /* JADX INFO: renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m820calculateScaledSizeE7KxVPU(long j) {
        float fM997getWidthimpl;
        float fM994getHeightimpl;
        if (!getUseIntrinsicSize()) {
            return j;
        }
        if (!m822hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.mo1848getIntrinsicSizeNHjbRc())) {
            fM997getWidthimpl = Size.m997getWidthimpl(j);
        } else {
            fM997getWidthimpl = Size.m997getWidthimpl(this.painter.mo1848getIntrinsicSizeNHjbRc());
        }
        if (!m821hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.mo1848getIntrinsicSizeNHjbRc())) {
            fM994getHeightimpl = Size.m994getHeightimpl(j);
        } else {
            fM994getHeightimpl = Size.m994getHeightimpl(this.painter.mo1848getIntrinsicSizeNHjbRc());
        }
        long jSize = SizeKt.Size(fM997getWidthimpl, fM994getHeightimpl);
        if (Size.m997getWidthimpl(j) != 0.0f && Size.m994getHeightimpl(j) != 0.0f) {
            return ScaleFactorKt.m2630timesUQTWf7w(jSize, this.contentScale.mo2516computeScaleFactorH7hwNQA(jSize, j));
        }
        return Size.Companion.m1006getZeroNHjbRc();
    }

    /* JADX INFO: renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m823modifyConstraintsZezNO4M(long j) {
        int iM3605getMinWidthimpl;
        int iM3604getMinHeightimpl;
        boolean z = Constraints.m3599getHasBoundedWidthimpl(j) && Constraints.m3598getHasBoundedHeightimpl(j);
        boolean z2 = Constraints.m3601getHasFixedWidthimpl(j) && Constraints.m3600getHasFixedHeightimpl(j);
        if ((!getUseIntrinsicSize() && z) || z2) {
            return Constraints.m3594copyZbe2FdA$default(j, Constraints.m3603getMaxWidthimpl(j), 0, Constraints.m3602getMaxHeightimpl(j), 0, 10, null);
        }
        long jMo1848getIntrinsicSizeNHjbRc = this.painter.mo1848getIntrinsicSizeNHjbRc();
        if (!m822hasSpecifiedAndFiniteWidthuvyYCjk(jMo1848getIntrinsicSizeNHjbRc)) {
            iM3605getMinWidthimpl = Constraints.m3605getMinWidthimpl(j);
        } else {
            iM3605getMinWidthimpl = Math.round(Size.m997getWidthimpl(jMo1848getIntrinsicSizeNHjbRc));
        }
        if (!m821hasSpecifiedAndFiniteHeightuvyYCjk(jMo1848getIntrinsicSizeNHjbRc)) {
            iM3604getMinHeightimpl = Constraints.m3604getMinHeightimpl(j);
        } else {
            iM3604getMinHeightimpl = Math.round(Size.m994getHeightimpl(jMo1848getIntrinsicSizeNHjbRc));
        }
        long jM820calculateScaledSizeE7KxVPU = m820calculateScaledSizeE7KxVPU(SizeKt.Size(ConstraintsKt.m3620constrainWidthK40F9xA(j, iM3605getMinWidthimpl), ConstraintsKt.m3619constrainHeightK40F9xA(j, iM3604getMinHeightimpl)));
        return Constraints.m3594copyZbe2FdA$default(j, ConstraintsKt.m3620constrainWidthK40F9xA(j, Math.round(Size.m997getWidthimpl(jM820calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m3619constrainHeightK40F9xA(j, Math.round(Size.m994getHeightimpl(jM820calculateScaledSizeE7KxVPU))), 0, 10, null);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        float fM997getWidthimpl;
        float fM994getHeightimpl;
        long jM1006getZeroNHjbRc;
        long jMo1848getIntrinsicSizeNHjbRc = this.painter.mo1848getIntrinsicSizeNHjbRc();
        if (m822hasSpecifiedAndFiniteWidthuvyYCjk(jMo1848getIntrinsicSizeNHjbRc)) {
            fM997getWidthimpl = Size.m997getWidthimpl(jMo1848getIntrinsicSizeNHjbRc);
        } else {
            fM997getWidthimpl = Size.m997getWidthimpl(contentDrawScope.mo1727getSizeNHjbRc());
        }
        if (m821hasSpecifiedAndFiniteHeightuvyYCjk(jMo1848getIntrinsicSizeNHjbRc)) {
            fM994getHeightimpl = Size.m994getHeightimpl(jMo1848getIntrinsicSizeNHjbRc);
        } else {
            fM994getHeightimpl = Size.m994getHeightimpl(contentDrawScope.mo1727getSizeNHjbRc());
        }
        long jSize = SizeKt.Size(fM997getWidthimpl, fM994getHeightimpl);
        if (Size.m997getWidthimpl(contentDrawScope.mo1727getSizeNHjbRc()) != 0.0f && Size.m994getHeightimpl(contentDrawScope.mo1727getSizeNHjbRc()) != 0.0f) {
            jM1006getZeroNHjbRc = ScaleFactorKt.m2630timesUQTWf7w(jSize, this.contentScale.mo2516computeScaleFactorH7hwNQA(jSize, contentDrawScope.mo1727getSizeNHjbRc()));
        } else {
            jM1006getZeroNHjbRc = Size.Companion.m1006getZeroNHjbRc();
        }
        long j = jM1006getZeroNHjbRc;
        long jMo774alignKFBX0sM = this.alignment.mo774alignKFBX0sM(IntSizeKt.IntSize(Math.round(Size.m997getWidthimpl(j)), Math.round(Size.m994getHeightimpl(j))), IntSizeKt.IntSize(Math.round(Size.m997getWidthimpl(contentDrawScope.mo1727getSizeNHjbRc())), Math.round(Size.m994getHeightimpl(contentDrawScope.mo1727getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
        float fM3778getXimpl = IntOffset.m3778getXimpl(jMo774alignKFBX0sM);
        float fM3779getYimpl = IntOffset.m3779getYimpl(jMo774alignKFBX0sM);
        contentDrawScope.getDrawContext().getTransform().translate(fM3778getXimpl, fM3779getYimpl);
        try {
            this.painter.m1854drawx_KDEd0(contentDrawScope, j, this.alpha, this.colorFilter);
            contentDrawScope.getDrawContext().getTransform().translate(-fM3778getXimpl, -fM3779getYimpl);
            contentDrawScope.drawContent();
        } catch (Throwable th) {
            contentDrawScope.getDrawContext().getTransform().translate(-fM3778getXimpl, -fM3779getYimpl);
            throw th;
        }
    }

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    private final boolean m822hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        if (!Size.m993equalsimpl0(j, Size.Companion.m1005getUnspecifiedNHjbRc())) {
            float fM997getWidthimpl = Size.m997getWidthimpl(j);
            if (!Float.isInfinite(fM997getWidthimpl) && !Float.isNaN(fM997getWidthimpl)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    private final boolean m821hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        if (!Size.m993equalsimpl0(j, Size.Companion.m1005getUnspecifiedNHjbRc())) {
            float fM994getHeightimpl = Size.m994getHeightimpl(j);
            if (!Float.isInfinite(fM994getHeightimpl) && !Float.isNaN(fM994getHeightimpl)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
