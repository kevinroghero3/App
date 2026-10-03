package androidx.compose.ui.layout;

import androidx.compose.ui.unit.Constraints;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class DefaultIntrinsicMeasurable implements Measurable {
    public static final int $stable = 8;
    private final IntrinsicMeasurable measurable;
    private final IntrinsicMinMax minMax;
    private final IntrinsicWidthHeight widthHeight;

    public DefaultIntrinsicMeasurable(@NotNull IntrinsicMeasurable intrinsicMeasurable, @NotNull IntrinsicMinMax intrinsicMinMax, @NotNull IntrinsicWidthHeight intrinsicWidthHeight) {
        this.measurable = intrinsicMeasurable;
        this.minMax = intrinsicMinMax;
        this.widthHeight = intrinsicWidthHeight;
    }

    public final IntrinsicMeasurable getMeasurable() {
        return this.measurable;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        return this.measurable.getParentData();
    }

    @Override // androidx.compose.ui.layout.Measurable
    /* JADX INFO: renamed from: measure-BRTryo0, reason: not valid java name */
    public Placeable mo2525measureBRTryo0(long j) {
        int iMinIntrinsicHeight;
        int iMinIntrinsicWidth;
        IntrinsicWidthHeight intrinsicWidthHeight = this.widthHeight;
        IntrinsicWidthHeight intrinsicWidthHeight2 = IntrinsicWidthHeight.Width;
        int iM3603getMaxWidthimpl = LayoutKt.LargeDimension;
        if (intrinsicWidthHeight == intrinsicWidthHeight2) {
            if (this.minMax == IntrinsicMinMax.Max) {
                iMinIntrinsicWidth = this.measurable.maxIntrinsicWidth(Constraints.m3602getMaxHeightimpl(j));
            } else {
                iMinIntrinsicWidth = this.measurable.minIntrinsicWidth(Constraints.m3602getMaxHeightimpl(j));
            }
            if (Constraints.m3598getHasBoundedHeightimpl(j)) {
                iM3603getMaxWidthimpl = Constraints.m3602getMaxHeightimpl(j);
            }
            return new FixedSizeIntrinsicsPlaceable(iMinIntrinsicWidth, iM3603getMaxWidthimpl);
        }
        if (this.minMax == IntrinsicMinMax.Max) {
            iMinIntrinsicHeight = this.measurable.maxIntrinsicHeight(Constraints.m3603getMaxWidthimpl(j));
        } else {
            iMinIntrinsicHeight = this.measurable.minIntrinsicHeight(Constraints.m3603getMaxWidthimpl(j));
        }
        if (Constraints.m3599getHasBoundedWidthimpl(j)) {
            iM3603getMaxWidthimpl = Constraints.m3603getMaxWidthimpl(j);
        }
        return new FixedSizeIntrinsicsPlaceable(iM3603getMaxWidthimpl, iMinIntrinsicHeight);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int i) {
        return this.measurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int i) {
        return this.measurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int i) {
        return this.measurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int i) {
        return this.measurable.maxIntrinsicHeight(i);
    }
}
