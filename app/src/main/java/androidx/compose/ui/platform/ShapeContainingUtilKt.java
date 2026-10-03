package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ShapeContainingUtilKt {
    public static /* synthetic */ boolean isInOutline$default(Outline outline, float f, float f2, Path path, Path path2, int i, Object obj) {
        if ((i & 8) != 0) {
            path = null;
        }
        if ((i & 16) != 0) {
            path2 = null;
        }
        return isInOutline(outline, f, f2, path, path2);
    }

    public static final boolean isInOutline(@NotNull Outline outline, float f, float f2, @Nullable Path path, @Nullable Path path2) {
        if (outline instanceof Outline.Rectangle) {
            return isInRectangle(((Outline.Rectangle) outline).getRect(), f, f2);
        }
        if (outline instanceof Outline.Rounded) {
            return isInRoundedRect((Outline.Rounded) outline, f, f2, path, path2);
        }
        if (outline instanceof Outline.Generic) {
            return isInPath(((Outline.Generic) outline).getPath(), f, f2, path, path2);
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean isInRectangle(Rect rect, float f, float f2) {
        return rect.getLeft() <= f && f < rect.getRight() && rect.getTop() <= f2 && f2 < rect.getBottom();
    }

    private static final boolean isInRoundedRect(Outline.Rounded rounded, float f, float f2, Path path, Path path2) {
        RoundRect roundRect = rounded.getRoundRect();
        if (f < roundRect.getLeft() || f >= roundRect.getRight() || f2 < roundRect.getTop() || f2 >= roundRect.getBottom()) {
            return false;
        }
        if (!cornersFit(roundRect)) {
            Path Path = path2 == null ? AndroidPath_androidKt.Path() : path2;
            Path.addRoundRect$default(Path, roundRect, null, 2, null);
            return isInPath(Path, f, f2, path, path2);
        }
        float fM903getXimpl = CornerRadius.m903getXimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs()) + roundRect.getLeft();
        float fM904getYimpl = CornerRadius.m904getYimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs()) + roundRect.getTop();
        float right = roundRect.getRight() - CornerRadius.m903getXimpl(roundRect.m979getTopRightCornerRadiuskKHJgLs());
        float fM904getYimpl2 = CornerRadius.m904getYimpl(roundRect.m979getTopRightCornerRadiuskKHJgLs()) + roundRect.getTop();
        float right2 = roundRect.getRight() - CornerRadius.m903getXimpl(roundRect.m977getBottomRightCornerRadiuskKHJgLs());
        float bottom = roundRect.getBottom() - CornerRadius.m904getYimpl(roundRect.m977getBottomRightCornerRadiuskKHJgLs());
        float bottom2 = roundRect.getBottom() - CornerRadius.m904getYimpl(roundRect.m976getBottomLeftCornerRadiuskKHJgLs());
        float fM903getXimpl2 = CornerRadius.m903getXimpl(roundRect.m976getBottomLeftCornerRadiuskKHJgLs()) + roundRect.getLeft();
        if (f < fM903getXimpl && f2 < fM904getYimpl) {
            return m2919isWithinEllipseVE1yxkc(f, f2, roundRect.m978getTopLeftCornerRadiuskKHJgLs(), fM903getXimpl, fM904getYimpl);
        }
        if (f < fM903getXimpl2 && f2 > bottom2) {
            return m2919isWithinEllipseVE1yxkc(f, f2, roundRect.m976getBottomLeftCornerRadiuskKHJgLs(), fM903getXimpl2, bottom2);
        }
        if (f > right && f2 < fM904getYimpl2) {
            return m2919isWithinEllipseVE1yxkc(f, f2, roundRect.m979getTopRightCornerRadiuskKHJgLs(), right, fM904getYimpl2);
        }
        if (f <= right2 || f2 <= bottom) {
            return true;
        }
        return m2919isWithinEllipseVE1yxkc(f, f2, roundRect.m977getBottomRightCornerRadiuskKHJgLs(), right2, bottom);
    }

    private static final boolean cornersFit(RoundRect roundRect) {
        return CornerRadius.m903getXimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs()) + CornerRadius.m903getXimpl(roundRect.m979getTopRightCornerRadiuskKHJgLs()) <= roundRect.getWidth() && CornerRadius.m903getXimpl(roundRect.m976getBottomLeftCornerRadiuskKHJgLs()) + CornerRadius.m903getXimpl(roundRect.m977getBottomRightCornerRadiuskKHJgLs()) <= roundRect.getWidth() && CornerRadius.m904getYimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs()) + CornerRadius.m904getYimpl(roundRect.m976getBottomLeftCornerRadiuskKHJgLs()) <= roundRect.getHeight() && CornerRadius.m904getYimpl(roundRect.m979getTopRightCornerRadiuskKHJgLs()) + CornerRadius.m904getYimpl(roundRect.m977getBottomRightCornerRadiuskKHJgLs()) <= roundRect.getHeight();
    }

    /* JADX INFO: renamed from: isWithinEllipse-VE1yxkc, reason: not valid java name */
    private static final boolean m2919isWithinEllipseVE1yxkc(float f, float f2, long j, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        float fM903getXimpl = CornerRadius.m903getXimpl(j);
        float fM904getYimpl = CornerRadius.m904getYimpl(j);
        return ((f5 * f5) / (fM903getXimpl * fM903getXimpl)) + ((f6 * f6) / (fM904getYimpl * fM904getYimpl)) <= 1.0f;
    }

    private static final boolean isInPath(Path path, float f, float f2, Path path2, Path path3) {
        Rect rect = new Rect(f - 0.005f, f2 - 0.005f, f + 0.005f, f2 + 0.005f);
        if (path2 == null) {
            path2 = AndroidPath_androidKt.Path();
        }
        Path.addRect$default(path2, rect, null, 2, null);
        if (path3 == null) {
            path3 = AndroidPath_androidKt.Path();
        }
        path3.mo1061opN5in7k0(path, path2, PathOperation.Companion.m1463getIntersectb3I0S0c());
        boolean zIsEmpty = path3.isEmpty();
        path3.reset();
        path2.reset();
        return !zIsEmpty;
    }
}
