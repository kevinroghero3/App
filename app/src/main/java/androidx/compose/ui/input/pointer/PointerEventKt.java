package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class PointerEventKt {
    public static final boolean changedToDown(@NotNull PointerInputChange pointerInputChange) {
        return (pointerInputChange.isConsumed() || pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) ? false : true;
    }

    public static final boolean changedToDownIgnoreConsumed(@NotNull PointerInputChange pointerInputChange) {
        return !pointerInputChange.getPreviousPressed() && pointerInputChange.getPressed();
    }

    public static final boolean changedToUp(@NotNull PointerInputChange pointerInputChange) {
        return (pointerInputChange.isConsumed() || !pointerInputChange.getPreviousPressed() || pointerInputChange.getPressed()) ? false : true;
    }

    public static final boolean changedToUpIgnoreConsumed(@NotNull PointerInputChange pointerInputChange) {
        return pointerInputChange.getPreviousPressed() && !pointerInputChange.getPressed();
    }

    public static final boolean positionChanged(@NotNull PointerInputChange pointerInputChange) {
        return !Offset.m925equalsimpl0(positionChangeInternal(pointerInputChange, false), Offset.Companion.m944getZeroF1C5BW0());
    }

    public static final boolean positionChangedIgnoreConsumed(@NotNull PointerInputChange pointerInputChange) {
        return !Offset.m925equalsimpl0(positionChangeInternal(pointerInputChange, true), Offset.Companion.m944getZeroF1C5BW0());
    }

    public static final long positionChange(@NotNull PointerInputChange pointerInputChange) {
        return positionChangeInternal(pointerInputChange, false);
    }

    public static final long positionChangeIgnoreConsumed(@NotNull PointerInputChange pointerInputChange) {
        return positionChangeInternal(pointerInputChange, true);
    }

    static /* synthetic */ long positionChangeInternal$default(PointerInputChange pointerInputChange, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return positionChangeInternal(pointerInputChange, z);
    }

    private static final long positionChangeInternal(PointerInputChange pointerInputChange, boolean z) {
        long jM932minusMKHz9U = Offset.m932minusMKHz9U(pointerInputChange.m2381getPositionF1C5BW0(), pointerInputChange.m2382getPreviousPositionF1C5BW0());
        return (z || !pointerInputChange.isConsumed()) ? jM932minusMKHz9U : Offset.Companion.m944getZeroF1C5BW0();
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use isConsumed instead", replaceWith = @ReplaceWith(expression = "isConsumed", imports = {}))
    public static final boolean positionChangeConsumed(@NotNull PointerInputChange pointerInputChange) {
        return pointerInputChange.isConsumed();
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use isConsumed instead", replaceWith = @ReplaceWith(expression = "isConsumed", imports = {}))
    public static final boolean anyChangeConsumed(@NotNull PointerInputChange pointerInputChange) {
        return pointerInputChange.isConsumed();
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use consume() instead.", replaceWith = @ReplaceWith(expression = "if (pressed != previousPressed) consume()", imports = {}))
    public static final void consumeDownChange(@NotNull PointerInputChange pointerInputChange) {
        if (pointerInputChange.getPressed() != pointerInputChange.getPreviousPressed()) {
            pointerInputChange.consume();
        }
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use consume() instead.", replaceWith = @ReplaceWith(expression = "if (positionChange() != Offset.Zero) consume()", imports = {}))
    public static final void consumePositionChange(@NotNull PointerInputChange pointerInputChange) {
        if (Offset.m925equalsimpl0(positionChange(pointerInputChange), Offset.Companion.m944getZeroF1C5BW0())) {
            return;
        }
        pointerInputChange.consume();
    }

    @Deprecated(message = "Use consume() instead", replaceWith = @ReplaceWith(expression = "consume()", imports = {}))
    public static final void consumeAllChanges(@NotNull PointerInputChange pointerInputChange) {
        pointerInputChange.consume();
    }

    @Deprecated(message = "Use isOutOfBounds() that supports minimum touch target", replaceWith = @ReplaceWith(expression = "this.isOutOfBounds(size, extendedTouchPadding)", imports = {}))
    /* JADX INFO: renamed from: isOutOfBounds-O0kMr_c, reason: not valid java name */
    public static final boolean m2324isOutOfBoundsO0kMr_c(@NotNull PointerInputChange pointerInputChange, long j) {
        long jM2381getPositionF1C5BW0 = pointerInputChange.m2381getPositionF1C5BW0();
        float fM928getXimpl = Offset.m928getXimpl(jM2381getPositionF1C5BW0);
        float fM929getYimpl = Offset.m929getYimpl(jM2381getPositionF1C5BW0);
        return fM928getXimpl < 0.0f || fM928getXimpl > ((float) IntSize.m3820getWidthimpl(j)) || fM929getYimpl < 0.0f || fM929getYimpl > ((float) IntSize.m3819getHeightimpl(j));
    }

    /* JADX INFO: renamed from: isOutOfBounds-jwHxaWs, reason: not valid java name */
    public static final boolean m2325isOutOfBoundsjwHxaWs(@NotNull PointerInputChange pointerInputChange, long j, long j2) {
        if (!PointerType.m2455equalsimpl0(pointerInputChange.m2384getTypeT8wyACA(), PointerType.Companion.m2462getTouchT8wyACA())) {
            return m2324isOutOfBoundsO0kMr_c(pointerInputChange, j);
        }
        long jM2381getPositionF1C5BW0 = pointerInputChange.m2381getPositionF1C5BW0();
        float fM928getXimpl = Offset.m928getXimpl(jM2381getPositionF1C5BW0);
        float fM929getYimpl = Offset.m929getYimpl(jM2381getPositionF1C5BW0);
        return fM928getXimpl < (-Size.m997getWidthimpl(j2)) || fM928getXimpl > ((float) IntSize.m3820getWidthimpl(j)) + Size.m997getWidthimpl(j2) || fM929getYimpl < (-Size.m994getHeightimpl(j2)) || fM929getYimpl > ((float) IntSize.m3819getHeightimpl(j)) + Size.m994getHeightimpl(j2);
    }
}
