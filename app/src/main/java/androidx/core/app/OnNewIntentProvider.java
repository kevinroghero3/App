package androidx.core.app;

import android.content.Intent;
import androidx.core.util.Consumer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface OnNewIntentProvider {
    void addOnNewIntentListener(@NotNull Consumer<Intent> consumer);

    void removeOnNewIntentListener(@NotNull Consumer<Intent> consumer);
}
