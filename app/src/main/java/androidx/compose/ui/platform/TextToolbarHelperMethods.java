package androidx.compose.ui.platform;

import android.view.ActionMode;
import android.view.View;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class TextToolbarHelperMethods {
    public static final int $stable = 0;
    public static final TextToolbarHelperMethods INSTANCE = new TextToolbarHelperMethods();

    private TextToolbarHelperMethods() {
    }

    public final ActionMode startActionMode(@NotNull View view, @NotNull ActionMode.Callback callback, int i) {
        return view.startActionMode(callback, i);
    }

    public final void invalidateContentRect(@NotNull ActionMode actionMode) {
        actionMode.invalidateContentRect();
    }
}
