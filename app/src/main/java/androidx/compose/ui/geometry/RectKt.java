package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class RectKt {
    /* JADX INFO: renamed from: Rect-tz77jQw, reason: not valid java name */
    public static final Rect m968Recttz77jQw(long j, long j2) {
        return new Rect(Offset.m928getXimpl(j), Offset.m929getYimpl(j), Offset.m928getXimpl(j) + Size.m997getWidthimpl(j2), Offset.m929getYimpl(j) + Size.m994getHeightimpl(j2));
    }

    /* JADX INFO: renamed from: Rect-0a9Yr6o, reason: not valid java name */
    public static final Rect m966Rect0a9Yr6o(long j, long j2) {
        return new Rect(Offset.m928getXimpl(j), Offset.m929getYimpl(j), Offset.m928getXimpl(j2), Offset.m929getYimpl(j2));
    }

    /* JADX INFO: renamed from: Rect-3MmeM6k, reason: not valid java name */
    public static final Rect m967Rect3MmeM6k(long j, float f) {
        return new Rect(Offset.m928getXimpl(j) - f, Offset.m929getYimpl(j) - f, Offset.m928getXimpl(j) + f, Offset.m929getYimpl(j) + f);
    }

    public static final Rect lerp(@NotNull Rect rect, @NotNull Rect rect2, float f) {
        return new Rect(MathHelpersKt.lerp(rect.getLeft(), rect2.getLeft(), f), MathHelpersKt.lerp(rect.getTop(), rect2.getTop(), f), MathHelpersKt.lerp(rect.getRight(), rect2.getRight(), f), MathHelpersKt.lerp(rect.getBottom(), rect2.getBottom(), f));
    }
}
