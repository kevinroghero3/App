package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactor;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
final class SkipToLookaheadNode extends Modifier.Node implements LayoutModifierNode {
    private final MutableState isEnabled$delegate;
    private Constraints lookaheadConstraints;
    private final MutableState scaleToBounds$delegate;

    public SkipToLookaheadNode(@Nullable ScaleToBoundsImpl scaleToBoundsImpl, @NotNull Function0<Boolean> function0) {
        this.scaleToBounds$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(scaleToBoundsImpl, null, 2, null);
        this.isEnabled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(function0, null, 2, null);
    }

    /* JADX INFO: renamed from: getLookaheadConstraints-DWUhwKw, reason: not valid java name */
    public final Constraints m286getLookaheadConstraintsDWUhwKw() {
        return this.lookaheadConstraints;
    }

    /* JADX INFO: renamed from: setLookaheadConstraints-_Sx5XlM, reason: not valid java name */
    public final void m287setLookaheadConstraints_Sx5XlM(@Nullable Constraints constraints) {
        this.lookaheadConstraints = constraints;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ScaleToBoundsImpl getScaleToBounds() {
        return (ScaleToBoundsImpl) this.scaleToBounds$delegate.getValue();
    }

    public final void setScaleToBounds(@Nullable ScaleToBoundsImpl scaleToBoundsImpl) {
        this.scaleToBounds$delegate.setValue(scaleToBoundsImpl);
    }

    public final Function0<Boolean> isEnabled() {
        return (Function0) this.isEnabled$delegate.getValue();
    }

    public final void setEnabled(@NotNull Function0<Boolean> function0) {
        this.isEnabled$delegate.setValue(function0);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo253measure3p2s80s(@NotNull final MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        if (measureScope.isLookingAhead()) {
            this.lookaheadConstraints = Constraints.m3591boximpl(j);
        }
        Constraints constraints = this.lookaheadConstraints;
        Intrinsics.checkNotNull(constraints);
        final Placeable placeableMo2525measureBRTryo0 = measurable.mo2525measureBRTryo0(constraints.m3609unboximpl());
        final long jIntSize = IntSizeKt.IntSize(placeableMo2525measureBRTryo0.getWidth(), placeableMo2525measureBRTryo0.getHeight());
        final long jM3617constrain4WqzIAM = ConstraintsKt.m3617constrain4WqzIAM(j, jIntSize);
        return MeasureScope.layout$default(measureScope, IntSize.m3820getWidthimpl(jM3617constrain4WqzIAM), IntSize.m3819getHeightimpl(jM3617constrain4WqzIAM), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SkipToLookaheadNode$measure$1
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
                final long jScaleFactor;
                ScaleToBoundsImpl scaleToBounds = this.this$0.getScaleToBounds();
                if (!this.this$0.isEnabled().invoke().booleanValue() || scaleToBounds == null) {
                    Placeable.PlacementScope.place$default(placementScope, placeableMo2525measureBRTryo0, 0, 0, 0.0f, 4, null);
                    return;
                }
                ContentScale contentScale = scaleToBounds.getContentScale();
                if (IntSize.m3820getWidthimpl(jIntSize) == 0 || IntSize.m3819getHeightimpl(jIntSize) == 0) {
                    jScaleFactor = ScaleFactorKt.ScaleFactor(1.0f, 1.0f);
                } else {
                    jScaleFactor = contentScale.mo2516computeScaleFactorH7hwNQA(IntSizeKt.m3832toSizeozmzZPI(jIntSize), IntSizeKt.m3832toSizeozmzZPI(jM3617constrain4WqzIAM));
                }
                long jMo774alignKFBX0sM = scaleToBounds.getAlignment().mo774alignKFBX0sM(IntSizeKt.IntSize(MathKt__MathJVMKt.roundToInt(IntSize.m3820getWidthimpl(jIntSize) * ScaleFactor.m2615getScaleXimpl(jScaleFactor)), MathKt__MathJVMKt.roundToInt(IntSize.m3819getHeightimpl(jIntSize) * ScaleFactor.m2616getScaleYimpl(jScaleFactor))), jM3617constrain4WqzIAM, measureScope.getLayoutDirection());
                Placeable.PlacementScope.placeWithLayer$default(placementScope, placeableMo2525measureBRTryo0, IntOffset.m3778getXimpl(jMo774alignKFBX0sM), IntOffset.m3779getYimpl(jMo774alignKFBX0sM), 0.0f, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.SkipToLookaheadNode$measure$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull GraphicsLayerScope graphicsLayerScope) {
                        graphicsLayerScope.setScaleX(ScaleFactor.m2615getScaleXimpl(jScaleFactor));
                        graphicsLayerScope.setScaleY(ScaleFactor.m2616getScaleYimpl(jScaleFactor));
                        graphicsLayerScope.mo1363setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(0.0f, 0.0f));
                    }
                }, 4, (Object) null);
            }
        }, 4, null);
    }
}
