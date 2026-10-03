package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class RoundRectKt {
    public static final RoundRect RoundRect(float f, float f2, float f3, float f4, float f5, float f6) {
        long jCornerRadius = CornerRadiusKt.CornerRadius(f5, f6);
        return new RoundRect(f, f2, f3, f4, jCornerRadius, jCornerRadius, jCornerRadius, jCornerRadius, null);
    }

    /* JADX INFO: renamed from: RoundRect-gG7oq9Y, reason: not valid java name */
    public static final RoundRect m982RoundRectgG7oq9Y(float f, float f2, float f3, float f4, long j) {
        return RoundRect(f, f2, f3, f4, CornerRadius.m903getXimpl(j), CornerRadius.m904getYimpl(j));
    }

    public static final RoundRect RoundRect(@NotNull Rect rect, float f, float f2) {
        return RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), f, f2);
    }

    /* JADX INFO: renamed from: RoundRect-sniSvfs, reason: not valid java name */
    public static final RoundRect m983RoundRectsniSvfs(@NotNull Rect rect, long j) {
        return RoundRect(rect, CornerRadius.m903getXimpl(j), CornerRadius.m904getYimpl(j));
    }

    /* JADX INFO: renamed from: RoundRect-ZAM2FJo, reason: not valid java name */
    public static final RoundRect m980RoundRectZAM2FJo(@NotNull Rect rect, long j, long j2, long j3, long j4) {
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), j, j2, j3, j4, null);
    }

    /* JADX INFO: renamed from: translate-Uv8p0NA, reason: not valid java name */
    public static final RoundRect m984translateUv8p0NA(@NotNull RoundRect roundRect, long j) {
        float left = roundRect.getLeft();
        float fM928getXimpl = Offset.m928getXimpl(j);
        float top = roundRect.getTop();
        float fM929getYimpl = Offset.m929getYimpl(j);
        float right = roundRect.getRight();
        float fM928getXimpl2 = Offset.m928getXimpl(j);
        float bottom = roundRect.getBottom();
        return new RoundRect(fM928getXimpl + left, fM929getYimpl + top, fM928getXimpl2 + right, Offset.m929getYimpl(j) + bottom, roundRect.m978getTopLeftCornerRadiuskKHJgLs(), roundRect.m979getTopRightCornerRadiuskKHJgLs(), roundRect.m977getBottomRightCornerRadiuskKHJgLs(), roundRect.m976getBottomLeftCornerRadiuskKHJgLs(), null);
    }

    public static final Rect getBoundingRect(@NotNull RoundRect roundRect) {
        return new Rect(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
    }

    public static final Rect getSafeInnerRect(@NotNull RoundRect roundRect) {
        float fMax = Math.max(CornerRadius.m903getXimpl(roundRect.m976getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.m903getXimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs()));
        float fMax2 = Math.max(CornerRadius.m904getYimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs()), CornerRadius.m904getYimpl(roundRect.m979getTopRightCornerRadiuskKHJgLs()));
        float fMax3 = Math.max(CornerRadius.m903getXimpl(roundRect.m979getTopRightCornerRadiuskKHJgLs()), CornerRadius.m903getXimpl(roundRect.m977getBottomRightCornerRadiuskKHJgLs()));
        float fMax4 = Math.max(CornerRadius.m904getYimpl(roundRect.m977getBottomRightCornerRadiuskKHJgLs()), CornerRadius.m904getYimpl(roundRect.m976getBottomLeftCornerRadiuskKHJgLs()));
        return new Rect(roundRect.getLeft() + (fMax * 0.29289323f), roundRect.getTop() + (fMax2 * 0.29289323f), roundRect.getRight() - (fMax3 * 0.29289323f), roundRect.getBottom() - (fMax4 * 0.29289323f));
    }

    public static final boolean isEmpty(@NotNull RoundRect roundRect) {
        return roundRect.getLeft() >= roundRect.getRight() || roundRect.getTop() >= roundRect.getBottom();
    }

    public static final boolean isFinite(@NotNull RoundRect roundRect) {
        float left = roundRect.getLeft();
        if (!Float.isInfinite(left) && !Float.isNaN(left)) {
            float top = roundRect.getTop();
            if (!Float.isInfinite(top) && !Float.isNaN(top)) {
                float right = roundRect.getRight();
                if (!Float.isInfinite(right) && !Float.isNaN(right)) {
                    float bottom = roundRect.getBottom();
                    if (!Float.isInfinite(bottom) && !Float.isNaN(bottom)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isRect(@NotNull RoundRect roundRect) {
        return (CornerRadius.m903getXimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs()) == 0.0f || CornerRadius.m904getYimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs()) == 0.0f) && (CornerRadius.m903getXimpl(roundRect.m979getTopRightCornerRadiuskKHJgLs()) == 0.0f || CornerRadius.m904getYimpl(roundRect.m979getTopRightCornerRadiuskKHJgLs()) == 0.0f) && ((CornerRadius.m903getXimpl(roundRect.m976getBottomLeftCornerRadiuskKHJgLs()) == 0.0f || CornerRadius.m904getYimpl(roundRect.m976getBottomLeftCornerRadiuskKHJgLs()) == 0.0f) && (CornerRadius.m903getXimpl(roundRect.m977getBottomRightCornerRadiuskKHJgLs()) == 0.0f || CornerRadius.m904getYimpl(roundRect.m977getBottomRightCornerRadiuskKHJgLs()) == 0.0f));
    }

    public static final boolean isEllipse(@NotNull RoundRect roundRect) {
        return CornerRadius.m903getXimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m903getXimpl(roundRect.m979getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m904getYimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m904getYimpl(roundRect.m979getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m903getXimpl(roundRect.m979getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m903getXimpl(roundRect.m977getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m904getYimpl(roundRect.m979getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m904getYimpl(roundRect.m977getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m903getXimpl(roundRect.m977getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m903getXimpl(roundRect.m976getBottomLeftCornerRadiuskKHJgLs()) && CornerRadius.m904getYimpl(roundRect.m977getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m904getYimpl(roundRect.m976getBottomLeftCornerRadiuskKHJgLs()) && ((double) roundRect.getWidth()) <= ((double) CornerRadius.m903getXimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs())) * 2.0d && ((double) roundRect.getHeight()) <= ((double) CornerRadius.m904getYimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs())) * 2.0d;
    }

    public static final boolean isCircle(@NotNull RoundRect roundRect) {
        return roundRect.getWidth() == roundRect.getHeight() && isEllipse(roundRect);
    }

    public static final float getMinDimension(@NotNull RoundRect roundRect) {
        return Math.min(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final float getMaxDimension(@NotNull RoundRect roundRect) {
        return Math.max(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final long getCenter(@NotNull RoundRect roundRect) {
        return OffsetKt.Offset(roundRect.getLeft() + (roundRect.getWidth() / 2.0f), roundRect.getTop() + (roundRect.getHeight() / 2.0f));
    }

    public static final boolean isSimple(@NotNull RoundRect roundRect) {
        return CornerRadius.m903getXimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m904getYimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs()) && CornerRadius.m903getXimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m903getXimpl(roundRect.m979getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m903getXimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m904getYimpl(roundRect.m979getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m903getXimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m903getXimpl(roundRect.m977getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m903getXimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m904getYimpl(roundRect.m977getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m903getXimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m903getXimpl(roundRect.m976getBottomLeftCornerRadiuskKHJgLs()) && CornerRadius.m903getXimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m904getYimpl(roundRect.m976getBottomLeftCornerRadiuskKHJgLs());
    }

    public static final RoundRect lerp(@NotNull RoundRect roundRect, @NotNull RoundRect roundRect2, float f) {
        return new RoundRect(MathHelpersKt.lerp(roundRect.getLeft(), roundRect2.getLeft(), f), MathHelpersKt.lerp(roundRect.getTop(), roundRect2.getTop(), f), MathHelpersKt.lerp(roundRect.getRight(), roundRect2.getRight(), f), MathHelpersKt.lerp(roundRect.getBottom(), roundRect2.getBottom(), f), CornerRadiusKt.m914lerp3Ry4LBc(roundRect.m978getTopLeftCornerRadiuskKHJgLs(), roundRect2.m978getTopLeftCornerRadiuskKHJgLs(), f), CornerRadiusKt.m914lerp3Ry4LBc(roundRect.m979getTopRightCornerRadiuskKHJgLs(), roundRect2.m979getTopRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m914lerp3Ry4LBc(roundRect.m977getBottomRightCornerRadiuskKHJgLs(), roundRect2.m977getBottomRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m914lerp3Ry4LBc(roundRect.m976getBottomLeftCornerRadiuskKHJgLs(), roundRect2.m976getBottomLeftCornerRadiuskKHJgLs(), f), null);
    }
}
