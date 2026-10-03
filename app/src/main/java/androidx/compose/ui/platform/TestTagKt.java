package androidx.compose.ui.platform;

import androidx.compose.ui.Modifier;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class TestTagKt {
    public static final Modifier testTag(@NotNull Modifier modifier, @NotNull String str) {
        return modifier.then(new TestTagElement(str));
    }
}
