package androidx.compose.ui.input.rotary;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class RotaryInputModifierKt {
    public static final Modifier onRotaryScrollEvent(@NotNull Modifier modifier, @NotNull Function1<? super RotaryScrollEvent, Boolean> function1) {
        return modifier.then(new RotaryInputElement(function1, null));
    }

    public static final Modifier onPreRotaryScrollEvent(@NotNull Modifier modifier, @NotNull Function1<? super RotaryScrollEvent, Boolean> function1) {
        return modifier.then(new RotaryInputElement(null, function1));
    }
}
