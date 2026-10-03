package androidx.compose.ui.platform;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class DebugUtilsKt {
    public static final void ifDebug(@NotNull Function0<Unit> function0) {
        function0.invoke();
    }
}
