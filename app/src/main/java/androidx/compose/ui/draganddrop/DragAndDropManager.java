package androidx.compose.ui.draganddrop;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface DragAndDropManager {
    /* JADX INFO: renamed from: drag-12SF9DM, reason: not valid java name */
    boolean mo799drag12SF9DM(@NotNull DragAndDropTransferData dragAndDropTransferData, long j, @NotNull Function1<? super DrawScope, Unit> function1);

    Modifier getModifier();

    boolean isInterestedNode(@NotNull DragAndDropModifierNode dragAndDropModifierNode);

    void registerNodeInterest(@NotNull DragAndDropModifierNode dragAndDropModifierNode);
}
