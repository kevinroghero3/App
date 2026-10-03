package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class OnGloballyPositionedModifierKt {
    public static final Modifier onGloballyPositioned(@NotNull Modifier modifier, @NotNull Function1<? super LayoutCoordinates, Unit> function1) {
        return modifier.then(new OnGloballyPositionedElement(function1));
    }
}
