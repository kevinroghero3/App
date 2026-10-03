package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "Use FocusEventModifierNode instead")
public interface FocusEventModifier extends Modifier.Element {
    void onFocusEvent(@NotNull FocusState focusState);

    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull FocusEventModifier focusEventModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            return FocusEventModifier.super.all(function1);
        }

        @Deprecated
        public static boolean any(@NotNull FocusEventModifier focusEventModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            return FocusEventModifier.super.any(function1);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull FocusEventModifier focusEventModifier, R r, @NotNull Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            return (R) FocusEventModifier.super.foldIn(r, function2);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull FocusEventModifier focusEventModifier, R r, @NotNull Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            return (R) FocusEventModifier.super.foldOut(r, function2);
        }

        @Deprecated
        public static Modifier then(@NotNull FocusEventModifier focusEventModifier, @NotNull Modifier modifier) {
            return FocusEventModifier.super.then(modifier);
        }
    }
}
