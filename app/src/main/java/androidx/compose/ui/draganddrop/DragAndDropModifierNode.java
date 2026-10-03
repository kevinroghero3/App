package androidx.compose.ui.draganddrop;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DelegatableNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface DragAndDropModifierNode extends DelegatableNode, DragAndDropTarget {
    boolean acceptDragAndDropTransfer(@NotNull DragAndDropEvent dragAndDropEvent);

    /* JADX INFO: renamed from: drag-12SF9DM, reason: not valid java name */
    void mo800drag12SF9DM(@NotNull DragAndDropTransferData dragAndDropTransferData, long j, @NotNull Function1<? super DrawScope, Unit> function1);
}
