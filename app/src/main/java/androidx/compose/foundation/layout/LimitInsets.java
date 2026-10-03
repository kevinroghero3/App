package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
final class LimitInsets implements WindowInsets {
    private final WindowInsets insets;
    private final int sides;

    public /* synthetic */ LimitInsets(WindowInsets windowInsets, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowInsets, i);
    }

    private LimitInsets(WindowInsets windowInsets, int i) {
        this.insets = windowInsets;
        this.sides = i;
    }

    public final WindowInsets getInsets() {
        return this.insets;
    }

    /* JADX INFO: renamed from: getSides-JoeWqyM, reason: not valid java name */
    public final int m476getSidesJoeWqyM() {
        return this.sides;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        int iM611getAllowLeftInRtlJoeWqyM$foundation_layout_release;
        if (layoutDirection == LayoutDirection.Ltr) {
            iM611getAllowLeftInRtlJoeWqyM$foundation_layout_release = WindowInsetsSides.Companion.m610getAllowLeftInLtrJoeWqyM$foundation_layout_release();
        } else {
            iM611getAllowLeftInRtlJoeWqyM$foundation_layout_release = WindowInsetsSides.Companion.m611getAllowLeftInRtlJoeWqyM$foundation_layout_release();
        }
        if (WindowInsetsSides.m604hasAnybkgdKaI$foundation_layout_release(this.sides, iM611getAllowLeftInRtlJoeWqyM$foundation_layout_release)) {
            return this.insets.getLeft(density, layoutDirection);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(@NotNull Density density) {
        if (WindowInsetsSides.m604hasAnybkgdKaI$foundation_layout_release(this.sides, WindowInsetsSides.Companion.m620getTopJoeWqyM())) {
            return this.insets.getTop(density);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        int iM613getAllowRightInRtlJoeWqyM$foundation_layout_release;
        if (layoutDirection == LayoutDirection.Ltr) {
            iM613getAllowRightInRtlJoeWqyM$foundation_layout_release = WindowInsetsSides.Companion.m612getAllowRightInLtrJoeWqyM$foundation_layout_release();
        } else {
            iM613getAllowRightInRtlJoeWqyM$foundation_layout_release = WindowInsetsSides.Companion.m613getAllowRightInRtlJoeWqyM$foundation_layout_release();
        }
        if (WindowInsetsSides.m604hasAnybkgdKaI$foundation_layout_release(this.sides, iM613getAllowRightInRtlJoeWqyM$foundation_layout_release)) {
            return this.insets.getRight(density, layoutDirection);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(@NotNull Density density) {
        if (WindowInsetsSides.m604hasAnybkgdKaI$foundation_layout_release(this.sides, WindowInsetsSides.Companion.m614getBottomJoeWqyM())) {
            return this.insets.getBottom(density);
        }
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LimitInsets)) {
            return false;
        }
        LimitInsets limitInsets = (LimitInsets) obj;
        return Intrinsics.areEqual(this.insets, limitInsets.insets) && WindowInsetsSides.m603equalsimpl0(this.sides, limitInsets.sides);
    }

    public int hashCode() {
        return (this.insets.hashCode() * 31) + WindowInsetsSides.m605hashCodeimpl(this.sides);
    }

    public String toString() {
        return CoreConstants.LEFT_PARENTHESIS_CHAR + this.insets + " only " + ((Object) WindowInsetsSides.m607toStringimpl(this.sides)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
