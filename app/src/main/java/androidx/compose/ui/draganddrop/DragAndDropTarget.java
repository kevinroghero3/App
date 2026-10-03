package androidx.compose.ui.draganddrop;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface DragAndDropTarget {
    default void onChanged(@NotNull DragAndDropEvent dragAndDropEvent) {
    }

    boolean onDrop(@NotNull DragAndDropEvent dragAndDropEvent);

    default void onEnded(@NotNull DragAndDropEvent dragAndDropEvent) {
    }

    default void onEntered(@NotNull DragAndDropEvent dragAndDropEvent) {
    }

    default void onExited(@NotNull DragAndDropEvent dragAndDropEvent) {
    }

    default void onMoved(@NotNull DragAndDropEvent dragAndDropEvent) {
    }

    default void onStarted(@NotNull DragAndDropEvent dragAndDropEvent) {
    }
}
