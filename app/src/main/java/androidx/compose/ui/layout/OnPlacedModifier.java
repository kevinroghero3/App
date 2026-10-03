package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface OnPlacedModifier extends Modifier.Element {
    void onPlaced(@NotNull LayoutCoordinates layoutCoordinates);

    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull OnPlacedModifier onPlacedModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            return OnPlacedModifier.super.all(function1);
        }

        @Deprecated
        public static boolean any(@NotNull OnPlacedModifier onPlacedModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            return OnPlacedModifier.super.any(function1);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull OnPlacedModifier onPlacedModifier, R r, @NotNull Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            return (R) OnPlacedModifier.super.foldIn(r, function2);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull OnPlacedModifier onPlacedModifier, R r, @NotNull Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            return (R) OnPlacedModifier.super.foldOut(r, function2);
        }

        @Deprecated
        public static Modifier then(@NotNull OnPlacedModifier onPlacedModifier, @NotNull Modifier modifier) {
            return OnPlacedModifier.super.then(modifier);
        }
    }
}
