package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface RowColumnMeasurePolicy {
    /* JADX INFO: renamed from: createConstraints-xF2OJ5Q */
    long mo436createConstraintsxF2OJ5Q(int i, int i2, int i3, int i4, boolean z);

    int crossAxisSize(@NotNull Placeable placeable);

    int mainAxisSize(@NotNull Placeable placeable);

    MeasureResult placeHelper(@NotNull Placeable[] placeableArr, @NotNull MeasureScope measureScope, int i, @NotNull int[] iArr, int i2, int i3, @Nullable int[] iArr2, int i4, int i5, int i6);

    void populateMainAxisPositions(int i, @NotNull int[] iArr, @NotNull int[] iArr2, @NotNull MeasureScope measureScope);

    /* JADX INFO: renamed from: createConstraints-xF2OJ5Q$default, reason: not valid java name */
    static /* synthetic */ long m546createConstraintsxF2OJ5Q$default(RowColumnMeasurePolicy rowColumnMeasurePolicy, int i, int i2, int i3, int i4, boolean z, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createConstraints-xF2OJ5Q");
        }
        if ((i5 & 16) != 0) {
            z = false;
        }
        return rowColumnMeasurePolicy.mo436createConstraintsxF2OJ5Q(i, i2, i3, i4, z);
    }
}
