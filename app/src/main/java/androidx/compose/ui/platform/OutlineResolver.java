package androidx.compose.ui.platform;

import android.graphics.Outline;
import android.os.Build;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class OutlineResolver {
    public static final int $stable = 8;
    private boolean cacheIsDirty;
    private final Outline cachedOutline;
    private Path cachedRrectPath;
    private boolean isSupportedOutline = true;
    private androidx.compose.ui.graphics.Outline outline;
    private boolean outlineNeeded;
    private Path outlinePath;
    private long rectSize;
    private long rectTopLeft;
    private float roundedCornerRadius;
    private Path tmpOpPath;
    private Path tmpPath;
    private RoundRect tmpRoundRect;
    private Path tmpTouchPointPath;
    private boolean usePathForClip;

    public OutlineResolver() {
        Outline outline = new Outline();
        outline.setAlpha(1.0f);
        this.cachedOutline = outline;
        this.rectTopLeft = Offset.Companion.m944getZeroF1C5BW0();
        this.rectSize = Size.Companion.m1006getZeroNHjbRc();
    }

    public final boolean getCacheIsDirty$ui_release() {
        return this.cacheIsDirty;
    }

    public final Outline getAndroidOutline() {
        updateCache();
        if (this.outlineNeeded && this.isSupportedOutline) {
            return this.cachedOutline;
        }
        return null;
    }

    public final boolean getOutlineClipSupported() {
        return !this.usePathForClip;
    }

    public final Path getClipPath() {
        updateCache();
        return this.outlinePath;
    }

    /* JADX INFO: renamed from: update-S_szKao, reason: not valid java name */
    public final boolean m2917updateS_szKao(@Nullable androidx.compose.ui.graphics.Outline outline, float f, boolean z, float f2, long j) {
        this.cachedOutline.setAlpha(f);
        boolean zAreEqual = Intrinsics.areEqual(this.outline, outline);
        if (!zAreEqual) {
            this.outline = outline;
            this.cacheIsDirty = true;
        }
        this.rectSize = j;
        boolean z2 = outline != null && (z || f2 > 0.0f);
        if (this.outlineNeeded != z2) {
            this.outlineNeeded = z2;
            this.cacheIsDirty = true;
        }
        return !zAreEqual;
    }

    /* JADX INFO: renamed from: isInOutline-k-4lQ0M, reason: not valid java name */
    public final boolean m2916isInOutlinek4lQ0M(long j) {
        androidx.compose.ui.graphics.Outline outline;
        if (this.outlineNeeded && (outline = this.outline) != null) {
            return ShapeContainingUtilKt.isInOutline(outline, Offset.m928getXimpl(j), Offset.m929getYimpl(j), this.tmpTouchPointPath, this.tmpOpPath);
        }
        return true;
    }

    public final void clipToOutline(@NotNull Canvas canvas) {
        Path clipPath = getClipPath();
        if (clipPath != null) {
            Canvas.m1140clipPathmtrdDE$default(canvas, clipPath, 0, 2, null);
            return;
        }
        float f = this.roundedCornerRadius;
        if (f > 0.0f) {
            Path Path = this.tmpPath;
            RoundRect roundRect = this.tmpRoundRect;
            if (Path == null || !m2915isSameBounds4L21HEs(roundRect, this.rectTopLeft, this.rectSize, f)) {
                float fM928getXimpl = Offset.m928getXimpl(this.rectTopLeft);
                float fM929getYimpl = Offset.m929getYimpl(this.rectTopLeft);
                float fM928getXimpl2 = Offset.m928getXimpl(this.rectTopLeft);
                float fM997getWidthimpl = Size.m997getWidthimpl(this.rectSize);
                RoundRect roundRectM982RoundRectgG7oq9Y = RoundRectKt.m982RoundRectgG7oq9Y(fM928getXimpl, fM929getYimpl, fM928getXimpl2 + fM997getWidthimpl, Offset.m929getYimpl(this.rectTopLeft) + Size.m994getHeightimpl(this.rectSize), CornerRadiusKt.CornerRadius$default(this.roundedCornerRadius, 0.0f, 2, null));
                if (Path == null) {
                    Path = AndroidPath_androidKt.Path();
                } else {
                    Path.reset();
                }
                Path.addRoundRect$default(Path, roundRectM982RoundRectgG7oq9Y, null, 2, null);
                this.tmpRoundRect = roundRectM982RoundRectgG7oq9Y;
                this.tmpPath = Path;
            }
            Canvas.m1140clipPathmtrdDE$default(canvas, Path, 0, 2, null);
            return;
        }
        Canvas.m1141clipRectN_I0leg$default(canvas, Offset.m928getXimpl(this.rectTopLeft), Offset.m929getYimpl(this.rectTopLeft), Offset.m928getXimpl(this.rectTopLeft) + Size.m997getWidthimpl(this.rectSize), Offset.m929getYimpl(this.rectTopLeft) + Size.m994getHeightimpl(this.rectSize), 0, 16, null);
    }

    private final void updateCache() {
        if (this.cacheIsDirty) {
            this.rectTopLeft = Offset.Companion.m944getZeroF1C5BW0();
            this.roundedCornerRadius = 0.0f;
            this.outlinePath = null;
            this.cacheIsDirty = false;
            this.usePathForClip = false;
            androidx.compose.ui.graphics.Outline outline = this.outline;
            if (outline != null && this.outlineNeeded && Size.m997getWidthimpl(this.rectSize) > 0.0f && Size.m994getHeightimpl(this.rectSize) > 0.0f) {
                this.isSupportedOutline = true;
                if (outline instanceof androidx.compose.ui.graphics.Outline.Rectangle) {
                    updateCacheWithRect(((androidx.compose.ui.graphics.Outline.Rectangle) outline).getRect());
                    return;
                } else if (outline instanceof androidx.compose.ui.graphics.Outline.Rounded) {
                    updateCacheWithRoundRect(((androidx.compose.ui.graphics.Outline.Rounded) outline).getRoundRect());
                    return;
                } else {
                    if (outline instanceof androidx.compose.ui.graphics.Outline.Generic) {
                        updateCacheWithPath(((androidx.compose.ui.graphics.Outline.Generic) outline).getPath());
                        return;
                    }
                    return;
                }
            }
            this.cachedOutline.setEmpty();
        }
    }

    private final void updateCacheWithRect(Rect rect) {
        this.rectTopLeft = OffsetKt.Offset(rect.getLeft(), rect.getTop());
        this.rectSize = SizeKt.Size(rect.getWidth(), rect.getHeight());
        this.cachedOutline.setRect(Math.round(rect.getLeft()), Math.round(rect.getTop()), Math.round(rect.getRight()), Math.round(rect.getBottom()));
    }

    private final void updateCacheWithRoundRect(RoundRect roundRect) {
        float fM903getXimpl = CornerRadius.m903getXimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs());
        this.rectTopLeft = OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
        this.rectSize = SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
        if (RoundRectKt.isSimple(roundRect)) {
            this.cachedOutline.setRoundRect(Math.round(roundRect.getLeft()), Math.round(roundRect.getTop()), Math.round(roundRect.getRight()), Math.round(roundRect.getBottom()), fM903getXimpl);
            this.roundedCornerRadius = fM903getXimpl;
            return;
        }
        Path Path = this.cachedRrectPath;
        if (Path == null) {
            Path = AndroidPath_androidKt.Path();
            this.cachedRrectPath = Path;
        }
        Path.reset();
        Path.addRoundRect$default(Path, roundRect, null, 2, null);
        updateCacheWithPath(Path);
    }

    private final void updateCacheWithPath(Path path) {
        if (Build.VERSION.SDK_INT > 28 || path.isConvex()) {
            Outline outline = this.cachedOutline;
            if (path instanceof AndroidPath) {
                outline.setConvexPath(((AndroidPath) path).getInternalPath());
                this.usePathForClip = !this.cachedOutline.canClip();
            } else {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
        } else {
            this.isSupportedOutline = false;
            this.cachedOutline.setEmpty();
            this.usePathForClip = true;
        }
        this.outlinePath = path;
    }

    /* JADX INFO: renamed from: isSameBounds-4L21HEs, reason: not valid java name */
    private final boolean m2915isSameBounds4L21HEs(RoundRect roundRect, long j, long j2, float f) {
        return roundRect != null && RoundRectKt.isSimple(roundRect) && roundRect.getLeft() == Offset.m928getXimpl(j) && roundRect.getTop() == Offset.m929getYimpl(j) && roundRect.getRight() == Offset.m928getXimpl(j) + Size.m997getWidthimpl(j2) && roundRect.getBottom() == Offset.m929getYimpl(j) + Size.m994getHeightimpl(j2) && CornerRadius.m903getXimpl(roundRect.m978getTopLeftCornerRadiuskKHJgLs()) == f;
    }
}
