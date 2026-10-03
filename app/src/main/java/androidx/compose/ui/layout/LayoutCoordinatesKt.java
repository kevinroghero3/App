package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntSize;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutCoordinatesKt {
    public static final long positionInRoot(@NotNull LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.mo2536localToRootMKHz9U(Offset.Companion.m944getZeroF1C5BW0());
    }

    public static final long positionInWindow(@NotNull LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.mo2538localToWindowMKHz9U(Offset.Companion.m944getZeroF1C5BW0());
    }

    public static final long positionOnScreen(@NotNull LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.mo2537localToScreenMKHz9U(Offset.Companion.m944getZeroF1C5BW0());
    }

    public static final Rect boundsInRoot(@NotNull LayoutCoordinates layoutCoordinates) {
        return LayoutCoordinates.localBoundingBoxOf$default(findRootCoordinates(layoutCoordinates), layoutCoordinates, false, 2, null);
    }

    public static final Rect boundsInWindow(@NotNull LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = findRootCoordinates(layoutCoordinates);
        float fM3820getWidthimpl = IntSize.m3820getWidthimpl(layoutCoordinatesFindRootCoordinates.mo2533getSizeYbymL2g());
        float fM3819getHeightimpl = IntSize.m3819getHeightimpl(layoutCoordinatesFindRootCoordinates.mo2533getSizeYbymL2g());
        Rect rectBoundsInRoot = boundsInRoot(layoutCoordinates);
        float left = rectBoundsInRoot.getLeft();
        if (left < 0.0f) {
            left = 0.0f;
        }
        if (left > fM3820getWidthimpl) {
            left = fM3820getWidthimpl;
        }
        float top = rectBoundsInRoot.getTop();
        if (top < 0.0f) {
            top = 0.0f;
        }
        if (top > fM3819getHeightimpl) {
            top = fM3819getHeightimpl;
        }
        float right = rectBoundsInRoot.getRight();
        if (right < 0.0f) {
            right = 0.0f;
        }
        if (right <= fM3820getWidthimpl) {
            fM3820getWidthimpl = right;
        }
        float bottom = rectBoundsInRoot.getBottom();
        float f = bottom >= 0.0f ? bottom : 0.0f;
        if (f <= fM3819getHeightimpl) {
            fM3819getHeightimpl = f;
        }
        if (left == fM3820getWidthimpl || top == fM3819getHeightimpl) {
            return Rect.Companion.getZero();
        }
        long jMo2538localToWindowMKHz9U = layoutCoordinatesFindRootCoordinates.mo2538localToWindowMKHz9U(OffsetKt.Offset(left, top));
        long jMo2538localToWindowMKHz9U2 = layoutCoordinatesFindRootCoordinates.mo2538localToWindowMKHz9U(OffsetKt.Offset(fM3820getWidthimpl, top));
        long jMo2538localToWindowMKHz9U3 = layoutCoordinatesFindRootCoordinates.mo2538localToWindowMKHz9U(OffsetKt.Offset(fM3820getWidthimpl, fM3819getHeightimpl));
        long jMo2538localToWindowMKHz9U4 = layoutCoordinatesFindRootCoordinates.mo2538localToWindowMKHz9U(OffsetKt.Offset(left, fM3819getHeightimpl));
        float fM928getXimpl = Offset.m928getXimpl(jMo2538localToWindowMKHz9U);
        float fM928getXimpl2 = Offset.m928getXimpl(jMo2538localToWindowMKHz9U2);
        float fM928getXimpl3 = Offset.m928getXimpl(jMo2538localToWindowMKHz9U4);
        float fM928getXimpl4 = Offset.m928getXimpl(jMo2538localToWindowMKHz9U3);
        float fMin = Math.min(fM928getXimpl, Math.min(fM928getXimpl2, Math.min(fM928getXimpl3, fM928getXimpl4)));
        float fMax = Math.max(fM928getXimpl, Math.max(fM928getXimpl2, Math.max(fM928getXimpl3, fM928getXimpl4)));
        float fM929getYimpl = Offset.m929getYimpl(jMo2538localToWindowMKHz9U);
        float fM929getYimpl2 = Offset.m929getYimpl(jMo2538localToWindowMKHz9U2);
        float fM929getYimpl3 = Offset.m929getYimpl(jMo2538localToWindowMKHz9U4);
        float fM929getYimpl4 = Offset.m929getYimpl(jMo2538localToWindowMKHz9U3);
        return new Rect(fMin, Math.min(fM929getYimpl, Math.min(fM929getYimpl2, Math.min(fM929getYimpl3, fM929getYimpl4))), fMax, Math.max(fM929getYimpl, Math.max(fM929getYimpl2, Math.max(fM929getYimpl3, fM929getYimpl4))));
    }

    public static final long positionInParent(@NotNull LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return parentLayoutCoordinates != null ? parentLayoutCoordinates.mo2534localPositionOfR5De75A(layoutCoordinates, Offset.Companion.m944getZeroF1C5BW0()) : Offset.Companion.m944getZeroF1C5BW0();
    }

    public static final Rect boundsInParent(@NotNull LayoutCoordinates layoutCoordinates) {
        Rect rectLocalBoundingBoxOf$default;
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return (parentLayoutCoordinates == null || (rectLocalBoundingBoxOf$default = LayoutCoordinates.localBoundingBoxOf$default(parentLayoutCoordinates, layoutCoordinates, false, 2, null)) == null) ? new Rect(0.0f, 0.0f, IntSize.m3820getWidthimpl(layoutCoordinates.mo2533getSizeYbymL2g()), IntSize.m3819getHeightimpl(layoutCoordinates.mo2533getSizeYbymL2g())) : rectLocalBoundingBoxOf$default;
    }

    public static final LayoutCoordinates findRootCoordinates(@NotNull LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (parentLayoutCoordinates != null) {
            LayoutCoordinates layoutCoordinates2 = parentLayoutCoordinates;
            parentLayoutCoordinates = parentLayoutCoordinates.getParentLayoutCoordinates();
            layoutCoordinates = layoutCoordinates2;
        }
        NodeCoordinator nodeCoordinator = layoutCoordinates instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinates : null;
        if (nodeCoordinator == null) {
            return layoutCoordinates;
        }
        for (NodeCoordinator wrappedBy$ui_release = nodeCoordinator.getWrappedBy$ui_release(); wrappedBy$ui_release != null; wrappedBy$ui_release = wrappedBy$ui_release.getWrappedBy$ui_release()) {
            nodeCoordinator = wrappedBy$ui_release;
        }
        return nodeCoordinator;
    }
}
