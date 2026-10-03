package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface FlowLineMeasurePolicy extends RowColumnMeasurePolicy {
    CrossAxisAlignment getCrossAxisAlignment();

    Arrangement.Horizontal getHorizontalArrangement();

    Arrangement.Vertical getVerticalArrangement();

    boolean isHorizontal();

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    default int mainAxisSize(@NotNull Placeable placeable) {
        return isHorizontal() ? placeable.getMeasuredWidth() : placeable.getMeasuredHeight();
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    default int crossAxisSize(@NotNull Placeable placeable) {
        return isHorizontal() ? placeable.getMeasuredHeight() : placeable.getMeasuredWidth();
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    /* JADX INFO: renamed from: createConstraints-xF2OJ5Q */
    default long mo436createConstraintsxF2OJ5Q(int i, int i2, int i3, int i4, boolean z) {
        if (isHorizontal()) {
            return RowKt.createRowConstraints(z, i, i2, i3, i4);
        }
        return ColumnKt.createColumnConstraints(z, i, i2, i3, i4);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    default MeasureResult placeHelper(@NotNull final Placeable[] placeableArr, @NotNull final MeasureScope measureScope, final int i, @NotNull final int[] iArr, int i2, final int i3, @Nullable final int[] iArr2, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        if (isHorizontal()) {
            i8 = i2;
            i7 = i3;
        } else {
            i7 = i2;
            i8 = i3;
        }
        return MeasureScope.layout$default(measureScope, i8, i7, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FlowLineMeasurePolicy$placeHelper$1$1
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
                int[] iArr3 = iArr2;
                int i9 = iArr3 != null ? iArr3[i4] : 0;
                for (int i10 = i5; i10 < i6; i10++) {
                    Placeable placeable = placeableArr[i10];
                    Intrinsics.checkNotNull(placeable);
                    int crossAxisPosition = this.getCrossAxisPosition(placeable, RowColumnImplKt.getRowColumnParentData(placeable), i3, measureScope.getLayoutDirection(), i) + i9;
                    if (this.isHorizontal()) {
                        Placeable.PlacementScope.place$default(placementScope, placeable, iArr[i10 - i5], crossAxisPosition, 0.0f, 4, null);
                    } else {
                        Placeable.PlacementScope.place$default(placementScope, placeable, crossAxisPosition, iArr[i10 - i5], 0.0f, 4, null);
                    }
                }
            }
        }, 4, null);
    }

    default int getCrossAxisPosition(@NotNull Placeable placeable, @Nullable RowColumnParentData rowColumnParentData, int i, @NotNull LayoutDirection layoutDirection, int i2) {
        CrossAxisAlignment crossAxisAlignment;
        if (rowColumnParentData == null || (crossAxisAlignment = rowColumnParentData.getCrossAxisAlignment()) == null) {
            crossAxisAlignment = getCrossAxisAlignment();
        }
        int iCrossAxisSize = crossAxisSize(placeable);
        if (isHorizontal()) {
            layoutDirection = LayoutDirection.Ltr;
        }
        return crossAxisAlignment.align$foundation_layout_release(i - iCrossAxisSize, layoutDirection, placeable, i2);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    default void populateMainAxisPositions(int i, @NotNull int[] iArr, @NotNull int[] iArr2, @NotNull MeasureScope measureScope) {
        if (isHorizontal()) {
            getHorizontalArrangement().arrange(measureScope, i, iArr, measureScope.getLayoutDirection(), iArr2);
        } else {
            getVerticalArrangement().arrange(measureScope, i, iArr, iArr2);
        }
    }
}
