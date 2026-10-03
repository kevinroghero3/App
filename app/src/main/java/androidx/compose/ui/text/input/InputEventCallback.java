package androidx.compose.ui.text.input;

import java.util.List;
import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "This function is not being used by any APIs. API is now deprecated and will be removed")
public interface InputEventCallback {
    void onEditCommands(@NotNull List<? extends EditCommand> list);

    /* JADX INFO: renamed from: onImeAction-KlQnJC8, reason: not valid java name */
    void m3331onImeActionKlQnJC8(int i);
}
