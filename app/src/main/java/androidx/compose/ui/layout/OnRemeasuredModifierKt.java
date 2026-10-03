package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntSize;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class OnRemeasuredModifierKt {
    public static final Modifier onSizeChanged(@NotNull Modifier modifier, @NotNull Function1<? super IntSize, Unit> function1) {
        return modifier.then(new OnSizeChangedModifier(function1));
    }
}
