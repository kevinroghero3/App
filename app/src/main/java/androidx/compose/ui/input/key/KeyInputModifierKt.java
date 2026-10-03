package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class KeyInputModifierKt {
    public static final Modifier onKeyEvent(@NotNull Modifier modifier, @NotNull Function1<? super KeyEvent, Boolean> function1) {
        return modifier.then(new KeyInputElement(function1, null));
    }

    public static final Modifier onPreviewKeyEvent(@NotNull Modifier modifier, @NotNull Function1<? super KeyEvent, Boolean> function1) {
        return modifier.then(new KeyInputElement(null, function1));
    }
}
