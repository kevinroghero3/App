package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class FocusEventModifierKt {
    public static final Modifier onFocusEvent(@NotNull Modifier modifier, @NotNull Function1<? super FocusState, Unit> function1) {
        return modifier.then(new FocusEventElement(function1));
    }
}
