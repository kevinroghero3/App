package androidx.compose.ui.draganddrop;

import android.view.DragEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class DragAndDropEvent {
    public static final int $stable = 8;
    private final DragEvent dragEvent;

    public DragAndDropEvent(@NotNull DragEvent dragEvent) {
        this.dragEvent = dragEvent;
    }

    public final DragEvent getDragEvent$ui_release() {
        return this.dragEvent;
    }
}
