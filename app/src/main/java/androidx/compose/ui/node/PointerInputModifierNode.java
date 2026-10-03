package androidx.compose.ui.node;

import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface PointerInputModifierNode extends DelegatableNode {
    default boolean interceptOutOfBoundsChildEvents() {
        return false;
    }

    void onCancelPointerInput();

    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    void mo2359onPointerEventH0pRuoY(@NotNull PointerEvent pointerEvent, @NotNull PointerEventPass pointerEventPass, long j);

    default boolean sharePointerInputWithSiblings() {
        return false;
    }

    default void onDensityChange() {
        onCancelPointerInput();
    }

    default void onViewConfigurationChange() {
        onCancelPointerInput();
    }
}
