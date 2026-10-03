package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface RememberManager {
    void deactivating(@NotNull ComposeNodeLifecycleCallback composeNodeLifecycleCallback, int i, int i2, int i3);

    void forgetting(@NotNull RememberObserver rememberObserver, int i, int i2, int i3);

    void releasing(@NotNull ComposeNodeLifecycleCallback composeNodeLifecycleCallback, int i, int i2, int i3);

    void remembering(@NotNull RememberObserver rememberObserver);

    void sideEffect(@NotNull Function0<Unit> function0);
}
