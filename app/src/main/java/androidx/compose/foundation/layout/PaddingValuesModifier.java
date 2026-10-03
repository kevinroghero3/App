package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
final class PaddingValuesModifier extends Modifier.Node implements LayoutModifierNode {
    private PaddingValues paddingValues;

    public final PaddingValues getPaddingValues() {
        return this.paddingValues;
    }

    public final void setPaddingValues(@NotNull PaddingValues paddingValues) {
        this.paddingValues = paddingValues;
    }

    public PaddingValuesModifier(@NotNull PaddingValues paddingValues) {
        this.paddingValues = paddingValues;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo253measure3p2s80s(@NotNull final MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        float f = 0;
        if (Dp.m3649compareTo0680j_4(this.paddingValues.mo472calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection()), Dp.m3650constructorimpl(f)) < 0 || Dp.m3649compareTo0680j_4(this.paddingValues.mo474calculateTopPaddingD9Ej5fM(), Dp.m3650constructorimpl(f)) < 0 || Dp.m3649compareTo0680j_4(this.paddingValues.mo473calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection()), Dp.m3650constructorimpl(f)) < 0 || Dp.m3649compareTo0680j_4(this.paddingValues.mo471calculateBottomPaddingD9Ej5fM(), Dp.m3650constructorimpl(f)) < 0) {
            throw new IllegalArgumentException("Padding must be non-negative");
        }
        int iMo2477roundToPx0680j_4 = measureScope.mo2477roundToPx0680j_4(this.paddingValues.mo472calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection())) + measureScope.mo2477roundToPx0680j_4(this.paddingValues.mo473calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection()));
        int iMo2477roundToPx0680j_5 = measureScope.mo2477roundToPx0680j_4(this.paddingValues.mo474calculateTopPaddingD9Ej5fM()) + measureScope.mo2477roundToPx0680j_4(this.paddingValues.mo471calculateBottomPaddingD9Ej5fM());
        final Placeable placeableMo2525measureBRTryo0 = measurable.mo2525measureBRTryo0(ConstraintsKt.m3622offsetNN6EwU(j, -iMo2477roundToPx0680j_4, -iMo2477roundToPx0680j_5));
        return MeasureScope.layout$default(measureScope, ConstraintsKt.m3620constrainWidthK40F9xA(j, placeableMo2525measureBRTryo0.getWidth() + iMo2477roundToPx0680j_4), ConstraintsKt.m3619constrainHeightK40F9xA(j, placeableMo2525measureBRTryo0.getHeight() + iMo2477roundToPx0680j_5), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.PaddingValuesModifier$measure$2
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
                Placeable.PlacementScope.place$default(placementScope, placeableMo2525measureBRTryo0, measureScope.mo2477roundToPx0680j_4(this.getPaddingValues().mo472calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection())), measureScope.mo2477roundToPx0680j_4(this.getPaddingValues().mo474calculateTopPaddingD9Ej5fM()), 0.0f, 4, null);
            }
        }, 4, null);
    }
}
