package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class SoftwareKeyboardInterceptionModifierKt {
    public static final Modifier onInterceptKeyBeforeSoftKeyboard(@NotNull Modifier modifier, @NotNull Function1<? super KeyEvent, Boolean> function1) {
        return modifier.then(new SoftKeyboardInterceptionElement(function1, null));
    }

    public static final Modifier onPreInterceptKeyBeforeSoftKeyboard(@NotNull Modifier modifier, @NotNull Function1<? super KeyEvent, Boolean> function1) {
        return modifier.then(new SoftKeyboardInterceptionElement(null, function1));
    }
}
