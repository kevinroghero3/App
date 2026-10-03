package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
final class FixedDpInsets implements WindowInsets {
    private final float bottomDp;
    private final float leftDp;
    private final float rightDp;
    private final float topDp;

    public /* synthetic */ FixedDpInsets(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    private FixedDpInsets(float f, float f2, float f3, float f4) {
        this.leftDp = f;
        this.topDp = f2;
        this.rightDp = f3;
        this.bottomDp = f4;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        return density.mo2477roundToPx0680j_4(this.leftDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(@NotNull Density density) {
        return density.mo2477roundToPx0680j_4(this.topDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        return density.mo2477roundToPx0680j_4(this.rightDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(@NotNull Density density) {
        return density.mo2477roundToPx0680j_4(this.bottomDp);
    }

    public String toString() {
        return "Insets(left=" + ((Object) Dp.m3661toStringimpl(this.leftDp)) + ", top=" + ((Object) Dp.m3661toStringimpl(this.topDp)) + ", right=" + ((Object) Dp.m3661toStringimpl(this.rightDp)) + ", bottom=" + ((Object) Dp.m3661toStringimpl(this.bottomDp)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FixedDpInsets)) {
            return false;
        }
        FixedDpInsets fixedDpInsets = (FixedDpInsets) obj;
        return Dp.m3655equalsimpl0(this.leftDp, fixedDpInsets.leftDp) && Dp.m3655equalsimpl0(this.topDp, fixedDpInsets.topDp) && Dp.m3655equalsimpl0(this.rightDp, fixedDpInsets.rightDp) && Dp.m3655equalsimpl0(this.bottomDp, fixedDpInsets.bottomDp);
    }

    public int hashCode() {
        int iM3656hashCodeimpl = Dp.m3656hashCodeimpl(this.leftDp);
        return (((((iM3656hashCodeimpl * 31) + Dp.m3656hashCodeimpl(this.topDp)) * 31) + Dp.m3656hashCodeimpl(this.rightDp)) * 31) + Dp.m3656hashCodeimpl(this.bottomDp);
    }
}
