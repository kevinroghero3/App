package androidx.compose.ui.window;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class AlignmentOffsetPositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final Alignment alignment;
    private final long offset;

    public /* synthetic */ AlignmentOffsetPositionProvider(Alignment alignment, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignment, j);
    }

    private AlignmentOffsetPositionProvider(Alignment alignment, long j) {
        this.alignment = alignment;
        this.offset = j;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    /* JADX INFO: renamed from: getOffset-nOcc-ac, reason: not valid java name */
    public final long m3905getOffsetnOccac() {
        return this.offset;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4, reason: not valid java name */
    public long mo3904calculatePositionllwVHH4(@NotNull IntRect intRect, long j, @NotNull LayoutDirection layoutDirection, long j2) {
        Alignment alignment = this.alignment;
        IntSize.Companion companion = IntSize.Companion;
        long jMo774alignKFBX0sM = alignment.mo774alignKFBX0sM(companion.m3825getZeroYbymL2g(), intRect.m3804getSizeYbymL2g(), layoutDirection);
        return IntOffset.m3782plusqkQi6aY(IntOffset.m3782plusqkQi6aY(IntOffset.m3782plusqkQi6aY(intRect.m3806getTopLeftnOccac(), jMo774alignKFBX0sM), IntOffset.m3786unaryMinusnOccac(this.alignment.mo774alignKFBX0sM(companion.m3825getZeroYbymL2g(), j2, layoutDirection))), IntOffsetKt.IntOffset(IntOffset.m3778getXimpl(this.offset) * (layoutDirection == LayoutDirection.Ltr ? 1 : -1), IntOffset.m3779getYimpl(this.offset)));
    }
}
