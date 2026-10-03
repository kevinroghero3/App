package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.util.MathHelpersKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class IntRectKt {
    /* JADX INFO: renamed from: IntRect-VbeCjmY, reason: not valid java name */
    public static final IntRect m3810IntRectVbeCjmY(long j, long j2) {
        return new IntRect(IntOffset.m3778getXimpl(j), IntOffset.m3779getYimpl(j), IntOffset.m3778getXimpl(j) + IntSize.m3820getWidthimpl(j2), IntOffset.m3779getYimpl(j) + IntSize.m3819getHeightimpl(j2));
    }

    /* JADX INFO: renamed from: IntRect-E1MhUcY, reason: not valid java name */
    public static final IntRect m3809IntRectE1MhUcY(long j, long j2) {
        return new IntRect(IntOffset.m3778getXimpl(j), IntOffset.m3779getYimpl(j), IntOffset.m3778getXimpl(j2), IntOffset.m3779getYimpl(j2));
    }

    /* JADX INFO: renamed from: IntRect-ar5cAso, reason: not valid java name */
    public static final IntRect m3811IntRectar5cAso(long j, int i) {
        return new IntRect(IntOffset.m3778getXimpl(j) - i, IntOffset.m3779getYimpl(j) - i, IntOffset.m3778getXimpl(j) + i, IntOffset.m3779getYimpl(j) + i);
    }

    public static final IntRect lerp(@NotNull IntRect intRect, @NotNull IntRect intRect2, float f) {
        return new IntRect(MathHelpersKt.lerp(intRect.getLeft(), intRect2.getLeft(), f), MathHelpersKt.lerp(intRect.getTop(), intRect2.getTop(), f), MathHelpersKt.lerp(intRect.getRight(), intRect2.getRight(), f), MathHelpersKt.lerp(intRect.getBottom(), intRect2.getBottom(), f));
    }

    public static final Rect toRect(@NotNull IntRect intRect) {
        return new Rect(intRect.getLeft(), intRect.getTop(), intRect.getRight(), intRect.getBottom());
    }

    public static final IntRect roundToIntRect(@NotNull Rect rect) {
        return new IntRect(Math.round(rect.getLeft()), Math.round(rect.getTop()), Math.round(rect.getRight()), Math.round(rect.getBottom()));
    }
}
