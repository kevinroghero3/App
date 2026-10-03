package androidx.compose.ui.geometry;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class RoundRect {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final RoundRect Zero = RoundRectKt.m982RoundRectgG7oq9Y(0.0f, 0.0f, 0.0f, 0.0f, CornerRadius.Companion.m913getZerokKHJgLs());
    private RoundRect _scaledRadiiRect;
    private final float bottom;
    private final long bottomLeftCornerRadius;
    private final long bottomRightCornerRadius;
    private final float left;
    private final float right;
    private final float top;
    private final long topLeftCornerRadius;
    private final long topRightCornerRadius;

    public /* synthetic */ RoundRect(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, j, j2, j3, j4);
    }

    public static final RoundRect getZero() {
        return Companion.getZero();
    }

    public final float component1() {
        return this.left;
    }

    public final float component2() {
        return this.top;
    }

    public final float component3() {
        return this.right;
    }

    public final float component4() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: component5-kKHJgLs, reason: not valid java name */
    public final long m970component5kKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* JADX INFO: renamed from: component6-kKHJgLs, reason: not valid java name */
    public final long m971component6kKHJgLs() {
        return this.topRightCornerRadius;
    }

    /* JADX INFO: renamed from: component7-kKHJgLs, reason: not valid java name */
    public final long m972component7kKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    /* JADX INFO: renamed from: component8-kKHJgLs, reason: not valid java name */
    public final long m973component8kKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    /* JADX INFO: renamed from: copy-MDFrsts, reason: not valid java name */
    public final RoundRect m975copyMDFrsts(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4) {
        return new RoundRect(f, f2, f3, f4, j, j2, j3, j4, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundRect)) {
            return false;
        }
        RoundRect roundRect = (RoundRect) obj;
        return Float.compare(this.left, roundRect.left) == 0 && Float.compare(this.top, roundRect.top) == 0 && Float.compare(this.right, roundRect.right) == 0 && Float.compare(this.bottom, roundRect.bottom) == 0 && CornerRadius.m902equalsimpl0(this.topLeftCornerRadius, roundRect.topLeftCornerRadius) && CornerRadius.m902equalsimpl0(this.topRightCornerRadius, roundRect.topRightCornerRadius) && CornerRadius.m902equalsimpl0(this.bottomRightCornerRadius, roundRect.bottomRightCornerRadius) && CornerRadius.m902equalsimpl0(this.bottomLeftCornerRadius, roundRect.bottomLeftCornerRadius);
    }

    public int hashCode() {
        return (((((((((((((Float.hashCode(this.left) * 31) + Float.hashCode(this.top)) * 31) + Float.hashCode(this.right)) * 31) + Float.hashCode(this.bottom)) * 31) + CornerRadius.m905hashCodeimpl(this.topLeftCornerRadius)) * 31) + CornerRadius.m905hashCodeimpl(this.topRightCornerRadius)) * 31) + CornerRadius.m905hashCodeimpl(this.bottomRightCornerRadius)) * 31) + CornerRadius.m905hashCodeimpl(this.bottomLeftCornerRadius);
    }

    private RoundRect(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
        this.topLeftCornerRadius = j;
        this.topRightCornerRadius = j2;
        this.bottomRightCornerRadius = j3;
        this.bottomLeftCornerRadius = j4;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getTop() {
        return this.top;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public /* synthetic */ RoundRect(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, (i & 16) != 0 ? CornerRadius.Companion.m913getZerokKHJgLs() : j, (i & 32) != 0 ? CornerRadius.Companion.m913getZerokKHJgLs() : j2, (i & 64) != 0 ? CornerRadius.Companion.m913getZerokKHJgLs() : j3, (i & 128) != 0 ? CornerRadius.Companion.m913getZerokKHJgLs() : j4, null);
    }

    /* JADX INFO: renamed from: getTopLeftCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m978getTopLeftCornerRadiuskKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* JADX INFO: renamed from: getTopRightCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m979getTopRightCornerRadiuskKHJgLs() {
        return this.topRightCornerRadius;
    }

    /* JADX INFO: renamed from: getBottomRightCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m977getBottomRightCornerRadiuskKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    /* JADX INFO: renamed from: getBottomLeftCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m976getBottomLeftCornerRadiuskKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public final float getHeight() {
        return this.bottom - this.top;
    }

    private final RoundRect scaledRadiiRect() {
        RoundRect roundRect = this._scaledRadiiRect;
        if (roundRect != null) {
            return roundRect;
        }
        float fMinRadius = minRadius(minRadius(minRadius(minRadius(1.0f, CornerRadius.m904getYimpl(this.bottomLeftCornerRadius), CornerRadius.m904getYimpl(this.topLeftCornerRadius), getHeight()), CornerRadius.m903getXimpl(this.topLeftCornerRadius), CornerRadius.m903getXimpl(this.topRightCornerRadius), getWidth()), CornerRadius.m904getYimpl(this.topRightCornerRadius), CornerRadius.m904getYimpl(this.bottomRightCornerRadius), getHeight()), CornerRadius.m903getXimpl(this.bottomRightCornerRadius), CornerRadius.m903getXimpl(this.bottomLeftCornerRadius), getWidth());
        float f = this.left;
        float f2 = this.top;
        float f3 = this.right;
        float f4 = this.bottom;
        float f5 = f * fMinRadius;
        float f6 = f2 * fMinRadius;
        float f7 = f3 * fMinRadius;
        float f8 = f4 * fMinRadius;
        RoundRect roundRect2 = new RoundRect(f5, f6, f7, f8, CornerRadiusKt.CornerRadius(CornerRadius.m903getXimpl(this.topLeftCornerRadius) * fMinRadius, CornerRadius.m904getYimpl(this.topLeftCornerRadius) * fMinRadius), CornerRadiusKt.CornerRadius(CornerRadius.m903getXimpl(this.topRightCornerRadius) * fMinRadius, CornerRadius.m904getYimpl(this.topRightCornerRadius) * fMinRadius), CornerRadiusKt.CornerRadius(CornerRadius.m903getXimpl(this.bottomRightCornerRadius) * fMinRadius, CornerRadius.m904getYimpl(this.bottomRightCornerRadius) * fMinRadius), CornerRadiusKt.CornerRadius(CornerRadius.m903getXimpl(this.bottomLeftCornerRadius) * fMinRadius, CornerRadius.m904getYimpl(this.bottomLeftCornerRadius) * fMinRadius), null);
        this._scaledRadiiRect = roundRect2;
        return roundRect2;
    }

    private final float minRadius(float f, float f2, float f3, float f4) {
        float f5 = f2 + f3;
        return (f5 <= f4 || f5 == 0.0f) ? f : Math.min(f, f4 / f5);
    }

    /* JADX INFO: renamed from: contains-k-4lQ0M, reason: not valid java name */
    public final boolean m974containsk4lQ0M(long j) {
        float fM928getXimpl;
        float fM929getYimpl;
        float fM903getXimpl;
        float fM904getYimpl;
        if (Offset.m928getXimpl(j) < this.left || Offset.m928getXimpl(j) >= this.right || Offset.m929getYimpl(j) < this.top || Offset.m929getYimpl(j) >= this.bottom) {
            return false;
        }
        RoundRect roundRectScaledRadiiRect = scaledRadiiRect();
        if (Offset.m928getXimpl(j) < this.left + CornerRadius.m903getXimpl(roundRectScaledRadiiRect.topLeftCornerRadius) && Offset.m929getYimpl(j) < this.top + CornerRadius.m904getYimpl(roundRectScaledRadiiRect.topLeftCornerRadius)) {
            fM928getXimpl = (Offset.m928getXimpl(j) - this.left) - CornerRadius.m903getXimpl(roundRectScaledRadiiRect.topLeftCornerRadius);
            fM929getYimpl = (Offset.m929getYimpl(j) - this.top) - CornerRadius.m904getYimpl(roundRectScaledRadiiRect.topLeftCornerRadius);
            fM903getXimpl = CornerRadius.m903getXimpl(roundRectScaledRadiiRect.topLeftCornerRadius);
            fM904getYimpl = CornerRadius.m904getYimpl(roundRectScaledRadiiRect.topLeftCornerRadius);
        } else if (Offset.m928getXimpl(j) > this.right - CornerRadius.m903getXimpl(roundRectScaledRadiiRect.topRightCornerRadius) && Offset.m929getYimpl(j) < this.top + CornerRadius.m904getYimpl(roundRectScaledRadiiRect.topRightCornerRadius)) {
            fM928getXimpl = (Offset.m928getXimpl(j) - this.right) + CornerRadius.m903getXimpl(roundRectScaledRadiiRect.topRightCornerRadius);
            fM929getYimpl = (Offset.m929getYimpl(j) - this.top) - CornerRadius.m904getYimpl(roundRectScaledRadiiRect.topRightCornerRadius);
            fM903getXimpl = CornerRadius.m903getXimpl(roundRectScaledRadiiRect.topRightCornerRadius);
            fM904getYimpl = CornerRadius.m904getYimpl(roundRectScaledRadiiRect.topRightCornerRadius);
        } else if (Offset.m928getXimpl(j) > this.right - CornerRadius.m903getXimpl(roundRectScaledRadiiRect.bottomRightCornerRadius) && Offset.m929getYimpl(j) > this.bottom - CornerRadius.m904getYimpl(roundRectScaledRadiiRect.bottomRightCornerRadius)) {
            fM928getXimpl = (Offset.m928getXimpl(j) - this.right) + CornerRadius.m903getXimpl(roundRectScaledRadiiRect.bottomRightCornerRadius);
            fM929getYimpl = (Offset.m929getYimpl(j) - this.bottom) + CornerRadius.m904getYimpl(roundRectScaledRadiiRect.bottomRightCornerRadius);
            fM903getXimpl = CornerRadius.m903getXimpl(roundRectScaledRadiiRect.bottomRightCornerRadius);
            fM904getYimpl = CornerRadius.m904getYimpl(roundRectScaledRadiiRect.bottomRightCornerRadius);
        } else {
            if (Offset.m928getXimpl(j) >= this.left + CornerRadius.m903getXimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius) || Offset.m929getYimpl(j) <= this.bottom - CornerRadius.m904getYimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius)) {
                return true;
            }
            fM928getXimpl = (Offset.m928getXimpl(j) - this.left) - CornerRadius.m903getXimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius);
            fM929getYimpl = (Offset.m929getYimpl(j) - this.bottom) + CornerRadius.m904getYimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius);
            fM903getXimpl = CornerRadius.m903getXimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius);
            fM904getYimpl = CornerRadius.m904getYimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius);
        }
        float f = fM928getXimpl / fM903getXimpl;
        float f2 = fM929getYimpl / fM904getYimpl;
        return (f * f) + (f2 * f2) <= 1.0f;
    }

    public String toString() {
        long j = this.topLeftCornerRadius;
        long j2 = this.topRightCornerRadius;
        long j3 = this.bottomRightCornerRadius;
        long j4 = this.bottomLeftCornerRadius;
        String str = GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1);
        if (!CornerRadius.m902equalsimpl0(j, j2) || !CornerRadius.m902equalsimpl0(j2, j3) || !CornerRadius.m902equalsimpl0(j3, j4)) {
            return "RoundRect(rect=" + str + ", topLeft=" + ((Object) CornerRadius.m909toStringimpl(j)) + ", topRight=" + ((Object) CornerRadius.m909toStringimpl(j2)) + ", bottomRight=" + ((Object) CornerRadius.m909toStringimpl(j3)) + ", bottomLeft=" + ((Object) CornerRadius.m909toStringimpl(j4)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
        if (CornerRadius.m903getXimpl(j) == CornerRadius.m904getYimpl(j)) {
            return "RoundRect(rect=" + str + ", radius=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m903getXimpl(j), 1) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
        return "RoundRect(rect=" + str + ", x=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m903getXimpl(j), 1) + ", y=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m904getYimpl(j), 1) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getZero$annotations() {
        }

        private Companion() {
        }

        public final RoundRect getZero() {
            return RoundRect.Zero;
        }
    }
}
