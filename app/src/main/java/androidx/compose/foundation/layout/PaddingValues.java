package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface PaddingValues {
    /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
    float mo471calculateBottomPaddingD9Ej5fM();

    /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
    float mo472calculateLeftPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection);

    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
    float mo473calculateRightPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection);

    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
    float mo474calculateTopPaddingD9Ej5fM();

    public static final class Absolute implements PaddingValues {
        public static final int $stable = 0;
        private final float bottom;
        private final float left;
        private final float right;
        private final float top;

        public /* synthetic */ Absolute(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, f2, f3, f4);
        }

        /* JADX INFO: renamed from: getBottom-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m534getBottomD9Ej5fM$annotations() {
        }

        /* JADX INFO: renamed from: getLeft-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m535getLeftD9Ej5fM$annotations() {
        }

        /* JADX INFO: renamed from: getRight-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m536getRightD9Ej5fM$annotations() {
        }

        /* JADX INFO: renamed from: getTop-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m537getTopD9Ej5fM$annotations() {
        }

        private Absolute(float f, float f2, float f3, float f4) {
            this.left = f;
            this.top = f2;
            this.right = f3;
            this.bottom = f4;
            if (f < 0.0f) {
                throw new IllegalArgumentException("Left padding must be non-negative");
            }
            if (f2 < 0.0f) {
                throw new IllegalArgumentException("Top padding must be non-negative");
            }
            if (f3 < 0.0f) {
                throw new IllegalArgumentException("Right padding must be non-negative");
            }
            if (f4 < 0.0f) {
                throw new IllegalArgumentException("Bottom padding must be non-negative");
            }
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
        public float mo472calculateLeftPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection) {
            return this.left;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
        public float mo474calculateTopPaddingD9Ej5fM() {
            return this.top;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
        public float mo473calculateRightPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection) {
            return this.right;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
        public float mo471calculateBottomPaddingD9Ej5fM() {
            return this.bottom;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Absolute)) {
                return false;
            }
            Absolute absolute = (Absolute) obj;
            return Dp.m3655equalsimpl0(this.left, absolute.left) && Dp.m3655equalsimpl0(this.top, absolute.top) && Dp.m3655equalsimpl0(this.right, absolute.right) && Dp.m3655equalsimpl0(this.bottom, absolute.bottom);
        }

        public int hashCode() {
            int iM3656hashCodeimpl = Dp.m3656hashCodeimpl(this.left);
            return (((((iM3656hashCodeimpl * 31) + Dp.m3656hashCodeimpl(this.top)) * 31) + Dp.m3656hashCodeimpl(this.right)) * 31) + Dp.m3656hashCodeimpl(this.bottom);
        }

        public String toString() {
            return "PaddingValues.Absolute(left=" + ((Object) Dp.m3661toStringimpl(this.left)) + ", top=" + ((Object) Dp.m3661toStringimpl(this.top)) + ", right=" + ((Object) Dp.m3661toStringimpl(this.right)) + ", bottom=" + ((Object) Dp.m3661toStringimpl(this.bottom)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public /* synthetic */ Absolute(float f, float f2, float f3, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Dp.m3650constructorimpl(0) : f, (i & 2) != 0 ? Dp.m3650constructorimpl(0) : f2, (i & 4) != 0 ? Dp.m3650constructorimpl(0) : f3, (i & 8) != 0 ? Dp.m3650constructorimpl(0) : f4, null);
        }
    }
}
