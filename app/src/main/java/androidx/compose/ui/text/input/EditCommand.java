package androidx.compose.ui.text.input;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface EditCommand {
    void applyTo(@NotNull EditingBuffer editingBuffer);
}
