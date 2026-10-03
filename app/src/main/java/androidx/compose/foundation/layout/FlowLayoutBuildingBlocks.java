package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class FlowLayoutBuildingBlocks {
    public static final int $stable = 8;
    private final long constraints;
    private final int crossAxisSpacing;
    private final int mainAxisSpacing;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final FlowLayoutOverflowState overflow;

    public /* synthetic */ FlowLayoutBuildingBlocks(int i, FlowLayoutOverflowState flowLayoutOverflowState, long j, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, flowLayoutOverflowState, j, i2, i3, i4);
    }

    private FlowLayoutBuildingBlocks(int i, FlowLayoutOverflowState flowLayoutOverflowState, long j, int i2, int i3, int i4) {
        this.maxItemsInMainAxis = i;
        this.overflow = flowLayoutOverflowState;
        this.constraints = j;
        this.maxLines = i2;
        this.mainAxisSpacing = i3;
        this.crossAxisSpacing = i4;
    }

    public static final class WrapInfo {
        public static final int $stable = 0;
        private final boolean isLastItemInContainer;
        private final boolean isLastItemInLine;

        /* JADX WARN: Illegal instructions before constructor call */
        public WrapInfo() {
            boolean z = false;
            this(z, z, 3, null);
        }

        public WrapInfo(boolean z, boolean z2) {
            this.isLastItemInLine = z;
            this.isLastItemInContainer = z2;
        }

        public /* synthetic */ WrapInfo(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
        }

        public final boolean isLastItemInLine() {
            return this.isLastItemInLine;
        }

        public final boolean isLastItemInContainer() {
            return this.isLastItemInContainer;
        }
    }

    public static final class WrapEllipsisInfo {
        public static final int $stable = 8;
        private final Measurable ellipsis;
        private final long ellipsisSize;
        private boolean placeEllipsisOnLastContentLine;
        private final Placeable placeable;

        public /* synthetic */ WrapEllipsisInfo(Measurable measurable, Placeable placeable, long j, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(measurable, placeable, j, z);
        }

        private WrapEllipsisInfo(Measurable measurable, Placeable placeable, long j, boolean z) {
            this.ellipsis = measurable;
            this.placeable = placeable;
            this.ellipsisSize = j;
            this.placeEllipsisOnLastContentLine = z;
        }

        public /* synthetic */ WrapEllipsisInfo(Measurable measurable, Placeable placeable, long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(measurable, placeable, j, (i & 8) != 0 ? true : z, null);
        }

        public final Measurable getEllipsis() {
            return this.ellipsis;
        }

        public final Placeable getPlaceable() {
            return this.placeable;
        }

        /* JADX INFO: renamed from: getEllipsisSize-OO21N7I, reason: not valid java name */
        public final long m445getEllipsisSizeOO21N7I() {
            return this.ellipsisSize;
        }

        public final boolean getPlaceEllipsisOnLastContentLine() {
            return this.placeEllipsisOnLastContentLine;
        }

        public final void setPlaceEllipsisOnLastContentLine(boolean z) {
            this.placeEllipsisOnLastContentLine = z;
        }
    }

    public final WrapEllipsisInfo getWrapEllipsisInfo(@NotNull WrapInfo wrapInfo, boolean z, int i, int i2, int i3, int i4) {
        WrapEllipsisInfo wrapEllipsisInfoEllipsisInfo$foundation_layout_release;
        if (!wrapInfo.isLastItemInContainer() || (wrapEllipsisInfoEllipsisInfo$foundation_layout_release = this.overflow.ellipsisInfo$foundation_layout_release(z, i, i2)) == null) {
            return null;
        }
        wrapEllipsisInfoEllipsisInfo$foundation_layout_release.setPlaceEllipsisOnLastContentLine(i >= 0 && (i4 == 0 || (i3 - IntIntPair.m190getFirstimpl(wrapEllipsisInfoEllipsisInfo$foundation_layout_release.m445getEllipsisSizeOO21N7I()) >= 0 && i4 < this.maxItemsInMainAxis)));
        return wrapEllipsisInfoEllipsisInfo$foundation_layout_release;
    }

    /* JADX INFO: renamed from: getWrapInfo-OpUlnko, reason: not valid java name */
    public final WrapInfo m444getWrapInfoOpUlnko(boolean z, int i, long j, @Nullable IntIntPair intIntPair, int i2, int i3, int i4, boolean z2, boolean z3) {
        if (intIntPair == null) {
            return new WrapInfo(true, true);
        }
        if (this.overflow.getType$foundation_layout_release() != FlowLayoutOverflow.OverflowType.Visible && (i2 >= this.maxLines || IntIntPair.m191getSecondimpl(j) - IntIntPair.m191getSecondimpl(intIntPair.m194unboximpl()) < 0)) {
            return new WrapInfo(true, true);
        }
        if (i != 0 && (i >= this.maxItemsInMainAxis || IntIntPair.m190getFirstimpl(j) - IntIntPair.m190getFirstimpl(intIntPair.m194unboximpl()) < 0)) {
            if (z2) {
                return new WrapInfo(true, true);
            }
            return new WrapInfo(true, m444getWrapInfoOpUlnko(z, 0, IntIntPair.m186constructorimpl(Constraints.m3603getMaxWidthimpl(this.constraints), (IntIntPair.m191getSecondimpl(j) - this.crossAxisSpacing) - i4), IntIntPair.m183boximpl(IntIntPair.m186constructorimpl(IntIntPair.m190getFirstimpl(intIntPair.m194unboximpl()) - this.mainAxisSpacing, IntIntPair.m191getSecondimpl(intIntPair.m194unboximpl()))), i2 + 1, i3 + i4, 0, true, false).isLastItemInContainer());
        }
        int iMax = i3 + Math.max(i4, IntIntPair.m191getSecondimpl(intIntPair.m194unboximpl()));
        IntIntPair intIntPairM449ellipsisSizeF35zmw$foundation_layout_release = z3 ? null : this.overflow.m449ellipsisSizeF35zmw$foundation_layout_release(z, i2, iMax);
        if (intIntPairM449ellipsisSizeF35zmw$foundation_layout_release != null) {
            intIntPairM449ellipsisSizeF35zmw$foundation_layout_release.m194unboximpl();
            if (i + 1 >= this.maxItemsInMainAxis || ((IntIntPair.m190getFirstimpl(j) - IntIntPair.m190getFirstimpl(intIntPair.m194unboximpl())) - this.mainAxisSpacing) - IntIntPair.m190getFirstimpl(intIntPairM449ellipsisSizeF35zmw$foundation_layout_release.m194unboximpl()) < 0) {
                if (z3) {
                    return new WrapInfo(true, true);
                }
                WrapInfo wrapInfoM444getWrapInfoOpUlnko = m444getWrapInfoOpUlnko(false, 0, IntIntPair.m186constructorimpl(Constraints.m3603getMaxWidthimpl(this.constraints), (IntIntPair.m191getSecondimpl(j) - this.crossAxisSpacing) - Math.max(i4, IntIntPair.m191getSecondimpl(intIntPair.m194unboximpl()))), intIntPairM449ellipsisSizeF35zmw$foundation_layout_release, i2 + 1, iMax, 0, true, true);
                return new WrapInfo(wrapInfoM444getWrapInfoOpUlnko.isLastItemInContainer(), wrapInfoM444getWrapInfoOpUlnko.isLastItemInContainer());
            }
        }
        return new WrapInfo(false, false);
    }
}
